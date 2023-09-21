package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

public class Ex07 {
// 리플렉션(reflection)
// ㄴ JDBC 리플렉션: 결과물(rs)에 대한 정보를 추출해서 사용할 수 있는 기술
	public static void main(String[] args) {
		//
		String sql = "SELECT table_name "
				+ " FROM tabs ";
		String tableName = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		ArrayList<String>tnList = null;
		
		conn = DBConn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			tnList = new ArrayList<>();
			
			if (rs.next()) {
				do {
			tableName = rs.getString(1);												
			tnList.add(tableName);
				} while (rs.next());
				
				printSalgrade(tnList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				//DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// [2] 테이블 명선택
		Scanner sc = new Scanner(System.in);
		System.out.println("테이블 이름 임력");
		tableName = sc.next();
		
		sql = String.format("SELECT * FROM %s", tableName);
		int columCount = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//System.out.println("칼럼수: " + rsmd.getColumnCount());
			 columCount = rsmd.getColumnCount();
//			for (int i = 1; i <= columCount; i++) {
//				String columName = rsmd.getColumnName(i);
//				int columType = rsmd.getColumnType(i);
//				String columTypeName = rsmd.getColumnTypeName(i);
//				int p = rsmd.getPrecision(i);
//				int s = rsmd.getScale(i);
//				System.out.println(columName+ "/"+columType+"/"+columTypeName
//						+"("+p+","+s+")");
//			}
			System.out.println("-".repeat(7*columCount));
			for (int i = 1; i <= columCount; i++) {
				System.out.printf("%s\t",rsmd.getColumnName(i));
			}
			System.out.println();
			System.out.println("-".repeat(7*columCount));
			//출력작업
			if (rs.next()) {
				do {
					for (int i = 1; i <= columCount; i++) {
						int columType = rsmd.getColumnType(i);
						int s = rsmd.getScale(i);
						if (columType == 2 && s == 0) {
							System.out.printf("%d / ", rs.getInt(i));
						}else if (columType == 2 && s != 0) {
							System.out.printf("%.2f / ", rs.getDouble(i));
						}else if (columType == 12) {
							System.out.printf("%s / ",rs.getString(i));
						}else if (columType == 93) {
							System.out.printf("%tF / ",rs.getDate(i));
						}
					}
					System.out.println();
				} while (rs.next());
				
			}else {
				System.out.println("레코드가 존재하지 않음");
			}
			//System.out.println();
			System.out.println("-".repeat(7*columCount));
			
			if (rs.next()) {
				do {
			
				} while (rs.next());
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("END");

	}// main

private static void printSalgrade(ArrayList<String> tnList) {
	System.out.println("[Scott 테이블 목록]");
	Iterator<String> ir = tnList.iterator();
	int count = 1;
	while (ir.hasNext()) {
		String tableName = ir.next();
		System.out.printf("%d. %s  ",count,tableName);
		if(count%5 == 0)System.out.println();
		count++;
	}
	System.out.println();
}
}// class

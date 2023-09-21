package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;

public class Ex02_03 {

	public static void main(String[] args) throws IOException {
		//부서정보 수정
		// 1. 수정하기 전의 원래값
		// 2. 부서번호 X, 부서명 + 지역명
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int deptno;
		String dname;
		String loc;
		String originalDname;
		String originalLoc;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		int rowCount =0;
		
		System.out.println("수정할 부서번호 입력: ");
		deptno = Integer.parseInt(br.readLine());
		System.out.println("수정할 부서명을 입력: ");
		dname = br.readLine();
		System.out.println("수정할 지역명을 입력: ");
		loc = br.readLine();
		DeptVO vo = null;
		// 1.해당 부서번호의 수정 전 부서명, 지역명 저장
		sql = String.format("SELECT * FROM dept WHERE deptno = %d", deptno);

		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				originalDname = rs.getString("dname");
				originalLoc = rs.getString("loc");
				vo = new DeptVO(deptno, originalDname, originalLoc);
				System.out.println(vo);
			}else {
				System.out.println("부서가 존재 하지 않음");
				return;
			}
			
			/////UPDATE//////
			if (dname.equals("")) dname = originalDname;
			if (loc.equals("")) loc = originalLoc;
			
			sql = String.format("UPDATE dept "
					+ " SET dname = '%s', loc = '%s'"
					+ " WHERE deptno = %d",dname,loc, deptno);
			
			//System.out.println(sql);
			rowCount = stmt.executeUpdate(sql);
			if (rowCount == 1) {
				System.out.println(">부서 수정 완료");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		DBConn.close();	
		
		System.out.println("end");
		
	}//main
}

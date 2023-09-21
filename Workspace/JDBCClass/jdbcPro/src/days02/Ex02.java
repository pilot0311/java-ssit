package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBConn;
// 자바에서 DML시 오토 커밋
public class Ex02 {

	public static void main(String[] args) throws IOException {
		// 1. dept 부서번호 조회 days01 Ex03
		// 2. dept 부서추가
		int deptno; //PK = NN+UK
		String dname;
		String loc;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("1. 부서번호 입력: ");
		deptno = Integer.parseInt(br.readLine());
		System.out.print("2. 부서명 입력: ");
		dname = br.readLine();
		System.out.print("3. 지역 입력: ");
		loc = br.readLine();
		String sql = String.format
		("INSERT INTO dept (deptno,dname,loc) VALUES (%d,'%s','%s')",deptno,dname,loc);
		
		Connection conn = null;
		//conn.setAutoCommit(true); -> 오토 커밋 기본값 true// false시 오토 커밋 안함
		Statement stmt = null;
		int rowCount = 0;
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			//stmt.executeQUERY(sql); SELECT 일떄만 사용
			//stmt.executeUpdate(sql); //INSERT,UPDATE,DELETE 할떄 사용
			rowCount = stmt.executeUpdate(sql);
			if (rowCount == 1) {
				System.out.println("INSERT 작업 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end");
		
	}//main
}//class

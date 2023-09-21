package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBConn;

public class Test02 {
	// emp테이블에서 한 사원의 정보를 입력 받아서 추가
	public static void main(String[] args) throws NumberFormatException, IOException {
		Connection conn = null;
		Statement stmt = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int empno;
		String ename;
		String job;
		String mgr;
		String hiredate;
		String sal;
		String comm;
		String deptno;
		//Date hiredate;
		int rowCount = 0;
		
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			
			System.out.println("사원번호: ");
			empno = Integer.parseInt(br.readLine());
			System.out.println("이름");
			ename = br.readLine();
			System.out.println("직업");
			job = br.readLine();
			System.out.println("상사번호");
			mgr = br.readLine();
			System.out.println("입사일");
			hiredate = br.readLine();
//			if(hiredate.equals("")) {
//				hiredate
//			}
			System.out.println("급여");
			sal = br.readLine();
			System.out.println("커미션");
			comm = br.readLine();
			System.out.println("부서번호");
			deptno = br.readLine();
			
			
			String sql = String.format("INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)"
					+ " VALUES (%d,'%s','%s','%s','%s','%s','%s','%s')", empno,ename,job,mgr,hiredate,sal,comm,deptno);
			System.out.println(sql);
			
			rowCount = stmt.executeUpdate(sql);
			if (rowCount == 1)System.out.println("INSERT 수행됨");
			
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
		
		
	}
}

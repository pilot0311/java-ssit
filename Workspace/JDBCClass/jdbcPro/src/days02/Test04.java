package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

import domain.DeptVO;
import domain.EmpVO;

public class Test04 {
	// emp 테이블에서 사원의 정보 수정
	//		수정할 사원번호 와 기타 사원정보를 입력받아 수정
	public static void main(String[] args) throws NumberFormatException, IOException {
		Connection conn = null;
		conn = DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int empno;
		
//		String ename;
//		String job;
//		int mgr;
//		String hiredate;
//		int sal;
//		int comm;
//		int deptno;
		
		String ename;
		String job;
		String mgr;
		String hiredate;
		String sal;
		String comm;
		String deptno;
		// 입력 값들
		String nename;
		String njob;
		String nmgr;
		String nhiredate;
		String nsal;
		String ncomm;
		String ndeptno;
		
		
		System.out.println("수정할 사원번호 입력: ");
		empno = Integer.parseInt(br.readLine());
		System.out.println("수정할 이름 입력: ");
		nename = br.readLine();
		System.out.println("수정할 job을 입력: ");
		njob = br.readLine();
		System.out.println("수정할 mgr을 입력: ");
		nmgr = br.readLine();
		System.out.println("수정할 hiredate을 입력: ");
		nhiredate = br.readLine();
		System.out.println("수정할 sal을 입력: ");
		nsal = br.readLine();
		System.out.println("수정할 comm을 입력: ");
		ncomm = br.readLine();
		System.out.println("수정할 deptno을 입력: ");
		ndeptno = br.readLine();
		
		String sql;
		
		try {
			 sql = String.format("Select * FROM emp WHERE empno = %d", empno);
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			if (rs.next()) {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getString("mgr");
					hiredate = rs.getString("hiredate");
					sal = rs.getString("sal");
					comm = rs.getString("comm");
					deptno = rs.getString("deptno");
					System.out.printf("%d,%s,%s,%s,%s\n",empno,ename,mgr,hiredate,comm);
							
			} else {
				System.out.println("사원이 존재 하지 않음");
				return;
			}
			//update
			if(nename.equals(""))nename = ename;
			if(njob.equals(""))njob = job;
			if(nmgr.equals(""))nmgr = mgr;
			if(nhiredate.equals(""))nhiredate = hiredate;
			if(nsal.equals(""))nsal = sal;
			if(ncomm.equals(""))ncomm = comm;
			if(ndeptno.equals(""))ndeptno = deptno;
			
			sql = String.format("UPDATE emp SET "
					+ " ename = '%s' "
					+ " job = '%s' "
					+ " mgr = '%s' "
					+ " hiredate = '%s' "
					+ " sal = '%s' "
					+ " comm = '%s'"
					+ " deptno = '%s' ",nename,njob);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("end");
		
		
	}
}

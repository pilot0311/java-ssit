package days02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;
import domain.EmpVO;

public class Test03 {
	// emp 테이블에서 사원 명으로 검색,부서명,job 검색
	//				like	in	like
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int searchCondition;
		String searchword;
		Connection conn =null;
		ResultSet rs = null;
		Statement stmt = null;
		
		int empno;
		String ename;
		String job;
		int mgr;
		String hiredate;
		int sal;
		int comm;
		int deptno;
		EmpVO vo = null;
		ArrayList<EmpVO>list = null;
		
		System.out.println("검색 조건을 입력: ");
		searchCondition = sc.nextInt();
		System.out.println("검색 조건을 입력: ");
		searchword = sc.next();
		
		//StringBuffer
		//StringBuilder
		String sql =  " SELECT * "
					+ " FROM emp "
					+ " WHERE ";
		
		if (searchCondition ==1) {	//부서번호
			sql += String.format(" deptno IN(%s)", searchword);
		}else if(searchCondition == 2) {	//사원명
			sql += String.format(" REGEXP_LIKE (ename, '%s', 'i')", searchword);
		}else if(searchCondition == 3){	//job
			sql += String.format(" REGEXP_LIKE (job, '%s', 'i')", searchword);
		}
		System.out.println(sql);
		
		
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			if (rs.next()) {
				list = new ArrayList<EmpVO>();
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getInt("mgr");
					hiredate = rs.getString("hiredate");
					sal = rs.getInt("sal");
					comm = rs.getInt("comm");
					deptno = rs.getInt("deptno");
					
					
					vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					list.add(vo);
				} while (rs.next());
			}//if
			printDeptList(list);
			
			
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
					
		
	}//main

	private static void printDeptList(ArrayList<EmpVO> list) {
		if (list == null) {
			System.out.println("사원이 존재 하지 않는다");
			return;
		}
		System.out.printf("검색 결과: %d개\n",list.size());
		Iterator<EmpVO> ir = list.iterator();
		while (ir.hasNext()) {
			EmpVO vo = ir.next();
			
			System.out.println(vo);
		}
		
		
	}
}

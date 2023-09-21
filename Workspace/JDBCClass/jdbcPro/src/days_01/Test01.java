package days_01;

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

public class Test01 {

	public static void main(String[] args) {
		// empvo 클래스 선언
		// emp 테이블의 모든 사원 정보를 출력
		// 조건) 부서번호를 입력 받아서
		// 해당 부서원들만 출력하는 코딩.
		// 출력은 printEmpList로 출력
		
		Connection conn = null;
		conn = DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		EmpVO evo = null;
		String sql = "SELECT * FROM emp";
		String sql2 = " WHERE deptno = ";
		String inputdeptno;
		ArrayList<EmpVO> list = null; 
	
		int empno;
		String ename;
		String job;
		int mgr;
		String hiredate;
		int sal;
		int comm;
		int deptno;
		
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("부서번호 입력(0입력시 모든 부서 조회): ");
			inputdeptno = sc.next();
			if (!inputdeptno.equals("0")) {
				sql += " WHERE deptno IN( ";
				sql += inputdeptno +")";
			} 
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
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
					evo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					list.add(evo);
				} while (rs.next());
			}//if
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		printList(list);
		
	}//main

	private static void printList(ArrayList<EmpVO> list) {
		
		if (list == null) {
			System.out.println("사원이 존재하지 않습니다");
			return;
		}
		Iterator<EmpVO> ir = list.iterator();
		while (ir.hasNext()) {
			
			EmpVO evo =  ir.next();
			System.out.println(evo);
			
		}
		
	}
}//class

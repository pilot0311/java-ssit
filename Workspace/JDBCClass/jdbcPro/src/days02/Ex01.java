package days02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBConn;

import domain.EmpVO;

public class Ex01 {

	public static void main(String[] args) {
		
		Connection conn =  null;
		String inputdeptno = "10";
		ResultSet rs = null;
		Statement stmt = null;
		ArrayList<EmpVO>list = null;
		
		int empno;
		String ename;
		String job;
		int mgr;
		String hiredate;
		int sal;
		int comm;
		int deptno = 10;
		EmpVO vo = null;
		
		
		String sql = String.format("SELECT * "
				+ " FROM emp "
				+ " WHERE deptno = %s ",deptno);
		conn = DBConn.getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				list = new ArrayList<EmpVO>();
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getInt("mgr");
					hiredate = rs.getString("hiredate");
					sal = rs.getInt("sal");
					comm = rs.getInt("comm");
					//deptno = rs.getInt("deptno");
					vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					list.add(vo);
				} while (rs.next());
			}
			
			printList(list);
			
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
		
	}

	private static void printList(ArrayList<EmpVO> list) {
		if (list == null) {
			System.out.println("사원 없음");
			return;
		}
		int count = list.size();
		int deptno = list.get(0).getDeptno();
		int i = 1;
		System.out.printf("%d 부서번호사원수: %d명\n",deptno,count);
		Iterator<EmpVO> ir = list.iterator();
		while (ir.hasNext()) {
			EmpVO vo = ir.next();
			System.out.printf("%d",i++);
			System.out.println(vo);
			
		}
		
	}
}//class

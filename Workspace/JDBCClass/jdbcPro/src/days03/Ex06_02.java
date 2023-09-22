package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;

public class Ex06_02 {
// CallableStatement 사용해서 emp테이블 crud 작업
// Ex05 시리즈  제출....
	public static void main(String[] args) {
		int empno;
		String ename;
		//String job;
		//int mgr;
		//String hiredate;
		//int sal;
		//int comm;
		int deptno;
		String sql ="{call up_updemp (?,?,?)}";
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		
		int rowCount = 0;

		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("사원번호,이름,부서번호 순서대로 입력");
			empno = sc.nextInt();
			ename = sc.next();
			deptno= sc.nextInt();
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, deptno);
			rowCount = cstmt.executeUpdate();
			if(rowCount == 1)System.out.println("사원업뎃 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end");
		
		
	}
}

//CREATE OR REPLACE PROCEDURE up_upddept
//(
//    pempno emp.empno%TYPE,
//    pename emp.ename%TYPE  := NULL,
//    pdeptno emp.deptno%TYPE := NULL
//)
//IS
//BEGIN
//
//     UPDATE emp
//    SET ename = NVL(pename,ename), deptno = NVL(pdeptno,deptno)
//    WHERE empno = pempno;
//
//    COMMIT;
//END;

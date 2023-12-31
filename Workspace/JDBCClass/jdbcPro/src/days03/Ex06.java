package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

public class Ex06 {

	public static void main(String[] args) {
		int empno;
		String ename;
		//String job;
		//int mgr;
		//String hiredate;
		//int sal;
		//int comm;
		int deptno;
		String sql ="{call up_insemp (?,?,?)}";
		
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
			if(rowCount == 1)System.out.println("사원추가 완료");
			
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

//create or replace PROCEDURE up_insemp
//(
//    pempno emp.empno%TYPE,
//    pename emp.ename%TYPE,
//    pdeptno emp.deptno%TYPE
//)
//IS
//    NO_FK_FOUND EXCEPTION;
//    PRAGMA EXCEPTION_INIT (NO_FK_FOUND,-02291);
//BEGIN
//    INSERT INTO emp (empno,ename,deptno) VALUES (pempno,pename,pdeptno);
//    COMMIT;
//EXCEPTION
//    WHEN DUP_VAL_ON_INDEX THEN
//        RAISE_APPLICATION_ERROR(-20001,'> QUERY PK 위반');
//    WHEN NO_FK_FOUND THEN
//        RAISE_APPLICATION_ERROR(-20002,'> QUERY deptno FK 위반');
//    WHEN OTHERS THEN    --그 외 모든 예외 발생 경우
//        RAISE_APPLICATION_ERROR(-20004,'> QUERY OTHERS EXCEPTION FOUND');
//END;

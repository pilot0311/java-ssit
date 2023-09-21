package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.util.DBConn;

public class Ex03 {
//	CallableStatement - 저장프로시저, 저장 함수
	//회원 가입
	// 아이디:[][아이디중복체크 버튼]
	// 이미사용중인 아이디입니다/사용가능한 아이디 입니다
	// 회원테이블 (emp)
	// 회원ID (empno)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("중복체크: ");
		int pID = sc.nextInt();
		
		//String sql = "{call up_idcheck(pid=>?,pcheck=>?)}";
		String sql = "{call up_idcheck(?,?)}";
		Connection conn = null;
		CallableStatement cstmt = null;
		int idCheck = 0;
		
		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, pID);
			// OUT용 매개변수
			cstmt.registerOutParameter(2,Types.INTEGER);
			 cstmt.executeUpdate();
			 idCheck = cstmt.getInt(2);
			System.out.println(idCheck==1?"중복입니다":"사용가능");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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

//--ID 중복체크 프로시저
//CREATE OR REPLACE PROCEDURE up_idcheck
//(
//    pid IN emp.empno%TYPE
//    ,pcheck OUT NUMBER
//)
//IS
//BEGIN
//    SELECT COUNT(*) INTO pcheck
//    FROM emp
//    WHERE empno = pid;
//--EXCEPTION
//END;
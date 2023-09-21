package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.util.DBConn;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("중복체크: ");
		int pID = sc.nextInt();
		String pPWD = sc.next();

		// String sql = "{call up_idcheck(pid=>?,pcheck=>?)}";
		String sql = "{call up_logon(?,?,?)}";
		Connection conn = null;
		CallableStatement cstmt = null;
		int logonCheck = 0;

		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, pID);
			cstmt.setString(2, pPWD);
			// OUT용 매개변수
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.executeUpdate();
			logonCheck = cstmt.getInt(3);
			System.out.println(logonCheck == 0 ? "로그인  성공" : logonCheck==1? "아이디 존재X":"비밀번호 틀림");
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

/*
 * 1. 로그인 처리 아이디 : [ kenik ] 비밀번호 : [ 1234 ]
 * 
 * [로그인] [회원가입] 2. up_logon 회원테이블 = 아이디(PK), 비밀번호 X emp = empno(PK), ename 3.
 * 로그인 성공 : 0 로그인 실패 ㄴ 아이디 존재하지 않으면 : 1 ㄴ 비밀번호 틀리면 : -1
 */
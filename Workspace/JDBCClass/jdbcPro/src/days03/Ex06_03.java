package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;

public class Ex06_03 {
// CallableStatement 사용해서 emp테이블 crud 작업
// Ex05 시리즈  제출....
	public static void main(String[] args) {
		int empno;
	
		String sql ="{call up_delEMP (?)}";
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		
		int rowCount = 0;

		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("사원번호 입력");
			empno = sc.nextInt();
			
			cstmt.setInt(1, empno);
			
			rowCount = cstmt.executeUpdate();
			if(rowCount == 1)System.out.println("사원삭제 완료");
			
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

//create or replace PROCEDURE up_delEMP
//(
//  -- 저장 프로시저의 파라미터 선언 시 자료형의 크기 X
//  -- 저장 프로시저의 파라미터 여러개 선언 시 콤파 연산자
//  --pempno NUMBER(4);
//  --pempno NUMBER
//  --pempno 파라미터모드 emp.EMPNO%TYPE
//  --        ㄴ IN(입력용,기본값),OUT(출력용), IN OUT(입출력용)
//  pempno IN emp.EMPNO%TYPE
//)
//IS
//BEGIN
//  DELETE FROM tbl_emp
//  WHERE empno = pempno;
//  COMMIT;
//--EXCEPTION
//  --예외처리
//END;

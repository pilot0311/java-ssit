package days02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;

public class Ex05_04 {
	// 부서 정보 삭제
	//days02.Ex02_04 -> PreparedStatement로 수정
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		String deptno;
		int rowCount = 0;
		
		System.out.println("삭제할 부서 번호를 입력: ");
		deptno = sc.next();
		
		String sql =  " DELETE "
					+ " FROM dept "
					+ " WHERE deptno = ? ";
		
		
		System.out.println(sql);
		
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptno);
			rowCount = pstmt.executeUpdate();
			
			if(rowCount > 0)System.out.println("부서 삭제 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("end");
					
		
	}//main
}


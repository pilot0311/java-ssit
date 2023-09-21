package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;
import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class Ex05 {

	public static void main(String[] args) {
		
		String sql = "{call up_seldept(?)}";
		Connection conn = null;
		CallableStatement cstmt = null;
		DeptVO vo = null;
		ArrayList<DeptVO> list = null;
		ResultSet rs = null;
		
		int deptno;
		String dname,loc;
		
		int logonCheck = 0;

		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			
			// OUT용 매개변수
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(1);
			
			//rs.isFirst();
			while (rs.next()) {
				deptno = rs.getInt("deptno");
				dname = rs.getString("dname");
				loc = rs.getString("loc");
				vo = new DeptVO(deptno, dname, loc);
				System.out.println(vo);
			}
			//System.out.println(logonCheck == 0 ? "로그인  성공" : logonCheck == 1 ? "아이디 존재X" : "비밀번호 틀림");
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

//CREATE OR REPLACE PROCEDURE up_seldept
//(
//    pdeotcursor OUT SYS_REFCURSOR
//)
//IS
//BEGIN
//    
//    OPEN pdeotcursor FOR SELECT * FROM dept;
//--EXCEPTION
//END;
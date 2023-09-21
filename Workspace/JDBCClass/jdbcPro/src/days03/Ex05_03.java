package days03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBConn;

import domain.DeptVO;

public class Ex05_03 {
//UPDATE
	public static void main(String[] args) {
		String sql = "{call up_upddept(?,?,?)}";
		//String sql = "{call up_upddept(pdeptno=>?,ploc=>?)}";
		
		Connection conn = null;
		CallableStatement cstmt = null;
		DeptVO vo = null;
		
		int deptno;
		String dname = "EQC",loc = "ESEOUL";
		
		int rowCount = 0;

		try {
			conn = DBConn.getConnection();
			cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, 50);
			cstmt.setString(2, dname);
			cstmt.setString(3, loc);
			rowCount = cstmt.executeUpdate();
			if(rowCount == 1)System.out.println("부서수정 완료");
			
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
		
		
	}//main
}// class


//CREATE OR REPLACE PROCEDURE up_upddept
//(
//    pdeptno DEPT.DEPTNO%TYPE,
//    pdname dept.DNAME% TYPE := NULL,
//    ploc dept.LOC%TYPE := NULL
//)
//IS
//    odname dept.DNAME% TYPE := NULL;
//    oloc dept.LOC%TYPE := NULL;
//BEGIN
//    /*
//    SELECT dname,LOC INTO odname, oloc
//    FROM dept WHERE deptno = pdeptno;
//
//    IF pdname IS NULL THEN
//        pdname := odname;
//    END IF;
//
//    IF ploc IS NULL THEN
//        ploc := oloc;
//    END IF;
//
//    UPDATE DEPT
//    SET dname = pdname, loc = ploc
//    WHERE DEPTNO = pdeptno;
//    */
//
//     UPDATE DEPT
//    SET dname = NVL(pdname,dname), loc = NVL(ploc,loc)
//    WHERE DEPTNO = pdeptno;
//
//    COMMIT;
//END;

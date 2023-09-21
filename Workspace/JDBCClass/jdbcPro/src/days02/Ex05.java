package days02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBConn;

import domain.DeptVO;

public class Ex05 {

	public static void main(String[] args) {
		// PreparedStateMent
		// days01.Ex03 -> PreparedStatement 수정
		// Scott.Dept 테이블 CRUD 작업
		// domain.DeptVO
		// dept 테이블 조회
		Connection conn = DBConn.getConnection();

		// 3. 작업자(statement) + Select
		PreparedStatement pstmt = null;
		String sql = "Select * FROM dept";
		ResultSet rs = null;
		int deptno;
		String dname = null;
		String loc = null;
		DeptVO vo = null;
		ArrayList<DeptVO> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// rs로부터 읽어올 다음 레코드(행)가 있니?
			// bollean rs.next() 다음 레코드 있으면 true
			// 다음 읽어올 레코드로 이동

			// 그 해당 레코드의 부서번호, 부서명, 지역명 읽기 작업
			// System.out.println(rs.next());//true
			// rs.getInt(1) == deptno

			if (rs.next()) {
				list = new ArrayList<DeptVO>();
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
					vo = new DeptVO(deptno, dname, loc);
					list.add(vo);
				} while (rs.next());
			} // if
			printDeptList(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("end");

	}// main

	private static void printDeptList(ArrayList<DeptVO> list) {
		if (list == null) {
			System.out.println("부서가 존재 하지 않는다");
			return;
		}

		Iterator<DeptVO> ir = list.iterator();
		while (ir.hasNext()) {
			DeptVO vo = ir.next();
			System.out.println(vo);
		}

	}// printDeptList
}

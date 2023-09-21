package days02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;

public class Ex05_02 {
//days02.Ex02_02 -> PreparedStatement로 수정
	public static void main(String[] args) {
		// 부서 검색한 후 -> 부서 정보 수정 + 삭제
		// 1: deptno, 2: dname, 3: loc
		Scanner sc = new Scanner(System.in);
		int searchCondition;
		String searchword;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int deptno;
		String dname;
		String loc;
		DeptVO vo = null;
		ArrayList<DeptVO> list = null;

		System.out.println("검색 조건을 입력: ");
		searchCondition = sc.nextInt();
		System.out.println("검색 조건을 입력: ");
		searchword = sc.next();

		// StringBuffer
		// StringBuilder
		String sql = " SELECT * " + " FROM dept " + " WHERE ";

		if (searchCondition == 1) { // 부서번호
			sql += " deptno = ? ";
		} else if (searchCondition == 2) { // 부서명
			//sql += " REGEXP_LIKE (dname, ?, 'i')";
			sql += " dname LIKE ?";
		} else if (searchCondition == 3) { // 지역명
			sql += " REGEXP_LIKE (loc, ?, 'i')";
		}
		System.out.println(sql);

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			switch (searchCondition) {
			case 1:
				pstmt.setInt(1, Integer.parseInt(searchword));
				break;
			case 2:
				pstmt.setString(1,"%"+searchword+"%");
				break;
			case 3:
				pstmt.setString(1, searchword);
				break;
			}
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<DeptVO>();
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					if (searchCondition == 2) {
						searchword = searchword.toUpperCase();
						dname = dname.replaceAll(searchword, "[" + searchword + "]");
					}
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
		System.out.printf("검색 결과: %d개\n", list.size());
		Iterator<DeptVO> ir = list.iterator();
		while (ir.hasNext()) {
			DeptVO vo = ir.next();

			System.out.println(vo);
		}

	}// main
}// class
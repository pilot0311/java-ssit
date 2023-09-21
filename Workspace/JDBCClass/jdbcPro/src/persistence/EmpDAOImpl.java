package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.EmpVO;

public class EmpDAOImpl implements EmpDAO {

	private Connection conn = null;
	private ResultSet rs = null;
	// private Statement stmt = null;
	private PreparedStatement pstmt = null;

	// setter DI
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	// constructor DI
	public EmpDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 검색
	public ArrayList<EmpVO> getSelect(int searchCondition, String searchWord) {
		ArrayList<EmpVO> list = null;

		int empno;
		String ename;
		String job;
		int mgr;
		String hiredate;
		int sal;
		int comm;
		int deptno;
		EmpVO vo = null;

		String sql = "SELECT * FROM emp WHERE ";

		if (searchCondition == 1) { // 부서번호
			sql += " deptno = ?";
		} else if (searchCondition == 2) { // 사원명
			sql += " REGEXP_LIKE (ename, ?, 'i')";
		} else if (searchCondition == 3) { // job
			sql += " REGEXP_LIKE (job, ?, 'i')";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			switch (searchCondition) {
			case 1:
				pstmt.setString(1, searchWord);
				break;
			case 2:
				pstmt.setString(1, searchWord);
				break;
			case 3:
				pstmt.setString(1, searchWord);
				break;
			}
	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<EmpVO>();
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getInt("mgr");
					hiredate = rs.getString("hiredate");
					sal = rs.getInt("sal");
					comm = rs.getInt("comm");
					deptno = rs.getInt("deptno");
					vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					list.add(vo);
				} while (rs.next());
			}

			// printList(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	// 조회
	public ArrayList<EmpVO> getSelect() {
		ArrayList<EmpVO> list = null;

		int empno;
		String ename;
		String job;
		int mgr;
		String hiredate;
		int sal;
		int comm;
		int deptno;
		EmpVO vo = null;

		String sql = "SELECT * FROM emp ";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<EmpVO>();
				do {
					empno = rs.getInt("empno");
					ename = rs.getString("ename");
					job = rs.getString("job");
					mgr = rs.getInt("mgr");
					hiredate = rs.getString("hiredate");
					sal = rs.getInt("sal");
					comm = rs.getInt("comm");
					deptno = rs.getInt("deptno");
					vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
					list.add(vo);
				} while (rs.next());
			}

			// printList(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	// 추가
	public int add(EmpVO vo) {
		int rowCount = 0;

		String sql = 
				"INSERT INTO emp ( empno, ename, job, mgr, hiredate, sal, comm, deptno ) "
						+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
//				vo.getEmpno(), vo.getEname(), vo.getJob(), vo.getMgr(), vo.getHiredate(), vo.getSal(), vo.getComm(),
//				vo.getDeptno());

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, vo.getEmpno());
			pstmt.setObject(2, vo.getEname());
			pstmt.setObject(3, vo.getJob());
			pstmt.setObject(4, vo.getMgr());
			pstmt.setObject(5, vo.getHiredate());
			pstmt.setObject(6, vo.getSal());
			pstmt.setObject(7, vo.getComm());
			pstmt.setObject(8, vo.getDeptno());
			
			rowCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rowCount;
	}

//사원번호 로 조회
	public EmpVO get(int empno) {

		String ename;
		String job;
		int mgr;
		String hiredate;
		int sal;
		int comm;
		int deptno;

		EmpVO vo = null;

		String sql = "SELECT * FROM emp WHERE empno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				empno = rs.getInt("empno");
				ename = rs.getString("ename");
				job = rs.getString("job");
				mgr = rs.getInt("mgr");
				hiredate = rs.getString("hiredate");
				sal = rs.getInt("sal");
				comm = rs.getInt("comm");
				deptno = rs.getInt("deptno");
				vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			}

			// printList(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return vo;
	}

// 업데이트
	public int update(EmpVO vo) {
		int rowCount = 0;

		String sql = "UPDATE emp " + " SET  ename = ?, job = ?, mgr = ?," + " sal = ?, comm = ?, deptno = ? "
						+ " WHERE empno = ?";
				//vo.getEname(), vo.getJob(), vo.getMgr(), vo.getSal(), vo.getComm(), vo.getDeptno(), vo.getEmpno());

		try {

			pstmt = conn.prepareStatement(sql);
			//pstmt.setObject(1, vo.getEmpno());
			pstmt.setObject(1, vo.getEname());
			pstmt.setObject(2, vo.getJob());
			pstmt.setObject(3, vo.getMgr());
			//pstmt.setObject(5, vo.getHiredate());
			pstmt.setObject(4, vo.getSal());
			pstmt.setObject(5, vo.getComm());
			pstmt.setObject(6, vo.getDeptno());
			pstmt.setObject(7, vo.getEmpno());
			rowCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rowCount;
	}

	public int delete(int empno) {
		int rowCount = 0;

		String sql = " DELETE " + " FROM emp " + " WHERE empno = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rowCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}

	// 수정
	// 삭제

}

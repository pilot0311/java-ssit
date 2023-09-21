package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.EmpVO;

public class EmpDAOImpl_stmt implements EmpDAO {

	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	//private PreparedStatement pstmt = null;

	//setter DI
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	// constructor DI
	public EmpDAOImpl_stmt(Connection conn) {
		super();
		this.conn = conn;
	}



	// 검색
	public ArrayList<EmpVO> getSelect(int searchCondition, String searchWord){
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
		
		if (searchCondition ==1) {	//부서번호
			sql += String.format(" deptno IN(%s)", searchWord);
		}else if(searchCondition == 2) {	//사원명
			sql += String.format(" REGEXP_LIKE (ename, '%s', 'i')", searchWord);
		}else if(searchCondition == 3){	//job
			sql += String.format(" REGEXP_LIKE (job, '%s', 'i')", searchWord);
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
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

			//printList(list);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;	
	}
	
	// 조회
	public ArrayList<EmpVO> getSelect(){
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
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
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

			//printList(list);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
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
	            String.format("INSERT INTO emp ( empno, ename, job, mgr, hiredate, sal, comm, deptno ) "
	                  + " VALUES ( %d, '%s', '%s', %d, '%s', %f, %f, %d)"
	                  , vo.getEmpno(), vo.getEname(),
	                  vo.getJob(), vo.getMgr(), vo.getHiredate(), vo.getSal(), 
	                  vo.getComm(), vo.getDeptno() );

	      try {
	         
	         stmt = conn.createStatement(); 
	         rowCount = stmt.executeUpdate(sql);


	      } catch (SQLException e) { 
	         e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
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

		String sql = "SELECT * FROM emp WHERE empno = " +empno;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
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

			//printList(list);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
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
		
		String sql = 
	    String.format("UPDATE emp "
	    		+ " SET  ename = '%s', job = '%s', mgr = %d,"
	    		+ " sal = %d, comm = %d, deptno = %d "
	            + " WHERE empno = %d"
	                  ,vo.getEname(),vo.getJob(), vo.getMgr(),
	                  vo.getSal(),vo.getComm(), vo.getDeptno(),vo.getEmpno());
	                  
	                  

	      try {
	         
	         stmt = conn.createStatement(); 
	         rowCount = stmt.executeUpdate(sql);


	      } catch (SQLException e) { 
	         e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
	         } catch (SQLException e) { 
	            e.printStackTrace();
	         }
	      }
		
		return rowCount;
	}

	public int delete(int empno) {
		int rowCount = 0;
		
		String sql =  " DELETE "
				+ " FROM emp "
				+ " WHERE empno = " + empno;
	
	try {
		stmt = conn.createStatement();
		rowCount = stmt.executeUpdate(sql);
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return rowCount;
	}
	
	// 수정
	// 삭제

}

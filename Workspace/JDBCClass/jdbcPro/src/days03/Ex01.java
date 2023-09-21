package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBConn;

import domain.SalgradeVO;

public class Ex01 {

	public static void main(String[] args) {
		
		String sql = "SELECT grade,losal,hisal,count(*)cnt "
				+ "FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal "
				+ "GROUP BY grade,losal,hisal "
				+ "ORDER BY grade ASC " ;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
//롬복 @builder 사용시 ->		
//SalgradeVO vo = new SalgradeVO.builder().grade(1).losal(1000).hisal().cnt().build();
		ArrayList<SalgradeVO>list = null;
		SalgradeVO vo = null;
		
		conn = DBConn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<SalgradeVO>();
			if (rs.next()) {
				do {
															
			vo = new SalgradeVO(rs.getInt(1),rs.getInt(2) ,rs.getInt(3),rs.getInt(4) );
			list.add(vo);
				} while (rs.next());
				
				printSalgrade(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				DBConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("END");
	}

	private static void printSalgrade(ArrayList<SalgradeVO> list) {
		//list.size()
		Iterator<SalgradeVO> ir = list.iterator();
		while (ir.hasNext()) {
			SalgradeVO vo=  ir.next();
			System.out.printf("%d등급 (%d ~ %d) - %d명\n",vo.getGrade(),vo.getLosal(),vo.getHisal(),vo.getCnt());
		}
		
	}
}

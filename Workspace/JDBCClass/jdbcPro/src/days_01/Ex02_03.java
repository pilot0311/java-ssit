package days_01;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class Ex02_03 {

	public static void main(String[] args) {
		
		OracleDataSource ds;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pwd = "tiger";
		Connection conn = null;
		
		try {
			ds = new OracleDataSource();
			ds.setURL(url);
			conn = ds.getConnection(user, pwd);
			//ds.setUser(user);
			//ds.setPassword(pwd);
			System.out.println(conn.isClosed());
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}//main
}

package days_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex02 {

	public static void main(String[] args) {
		// 1. jdbc driver 로딩
		// 2. Connection DriverManager.getConnection()
		// 3. Statement CRUD
		// 4. Connection Close
		
		
		
		String className ="oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn.isClosed()); //닫혀있으면 true 열려있으면 false 반환
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//main
}

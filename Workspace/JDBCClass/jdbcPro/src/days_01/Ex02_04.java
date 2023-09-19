package days_01;

import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBConn;

public class Ex02_04 {

	public static void main(String[] args) throws SQLException {
		
		String ipAddr = "192.168.10.167";
		String url = String.format("jdbc:oracle:thin:@%s:1521:xe",ipAddr);
		String user = "scott";
		String pwd = "tiger";
		//Connection conn = DBConn.getConnection();	//내 DB
		Connection conn = DBConn.getConnection(url,user,pwd); //딴 사람DB
		System.out.println(conn.isClosed());
		
		
		DBConn.close();
		System.out.println("END");
		
	}//main
}

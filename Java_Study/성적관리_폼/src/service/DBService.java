package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Single-ton : ��ü1���� �����ؼ� ��������
	static DBService single = null;

	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user= "test";
		String pwd = "test";
		
		conn = DriverManager.getConnection(url,user,pwd);
		
		return conn;
	}
	
	
	public Connection getConnection(String user,String pwd) throws SQLException {
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
		conn = DriverManager.getConnection(url,user,pwd);
		
		return conn;
	}
	
	
	
	
	
}

package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyMain_DBTest2 {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";

		Connection conn = DriverManager.getConnection(url, user, password);

		Statement stmt = conn.createStatement();

		String sql = "select sabun, sasex, sapay,saname,deptno,sajob,sahire,samgr from sawon";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int sabun = rs.getInt(1);
			String sasex = rs.getString(2);
			int sapay = rs.getInt(3);
			String saname = rs.getString(4);
			int deptno = rs.getInt(5);
			String sajob = rs.getString(6);
			String sahire = rs.getString(7).substring(0, 10);
			int samgr = rs.getInt(8);

			System.out.printf("%d||%s||%d||%s||%d||%s||%s||%d\n", sabun, sasex, sapay, saname, deptno, sajob, sahire,
					samgr);

		}
 
		rs.close();
		stmt.close();
		conn.close();
		
	}
}

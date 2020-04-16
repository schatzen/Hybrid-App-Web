package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyMain_DBTest2_sawon {

	//0순위 : ojdbc14.jar(반드시해야된다)
	//        ojdbc50.jar ojdbc60.jar(안해도 된다)
	// OrcleDriver Load
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1.Connection 얻어오기
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user		= "test";
		String password	= "test";
		Connection conn = DriverManager.getConnection(
				                        url, user, password);
				
		//2.SQL명령 처리객체 얻기
		//  SQL-> DDL DCL DML 모든 SQL을 처리한다
		Statement stmt = conn.createStatement();
		
		
		
		//3.결과행처리객체 :ResultSet
		String sql   = "select * from sawon";
		ResultSet rs = stmt.executeQuery(sql);
		//전체데이터 조회
		while(rs.next()) {
			//System.out.println("----");
			//현재 rs가 가리키는 행(레코드)에서 열(컬럼) 추출
			//                        heading
			int sabun		=	rs.getInt("sabun");
			String saname	=	rs.getString("saname");
			
			
			String sahire	=	rs.getString("sahire")
					              .substring(0, 10);
			
			
			System.out.printf("%d/%s/%s\n",sabun,saname,sahire);
		}
		
		//닫기:열기 역순
		rs.close();
		stmt.close();
		conn.close();	
			
		//SQL Injection(주입): 보안취약
		//Statement사용시
		String id="hong or 1=1 ",pwd="1234";
		String sql1 = 
		"select * from member where id=" + id + " and pwd=" + pwd;
		System.out.println(sql1);
		
		//PreparedStatment사용시 : 보안성좋다
		String sql2 = "select * from member where id=? and pwd=?";
		
		
		
		

	}

}

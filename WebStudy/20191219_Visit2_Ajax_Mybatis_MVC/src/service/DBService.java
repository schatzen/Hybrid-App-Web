package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBService {
	
	//INTERFACE: 객체의 사용설명서와 같다
	DataSource ds = null;
	
	//SINGLE-TON: 객체를 1개만 생성하여 서비스한다
	static DBService single = null;
	
	public static DBService getInstance() {
		
		if (single == null)
			single = new DBService();
		return single;
		
	}
	
	public DBService() {
		try {
			
			//JNDI(Java Naming Directory Interface)
			//기능을 처리하는 객체
			InitialContext ic = new InitialContext();
			
			//자원검색(DIRECTORY) => Context위치
			Context ctx = (Context)ic.lookup("java:comp/env");
			
			//Context내에 등록된 자원 검색
			ds = (DataSource) ctx.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
		
	}
}

package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {

	//interface(��ü�� ��뼳��)
	DataSource ds=null;
	
	//Single-ton : ��ü1���� �����ؼ� ��������
	static DBService single = null;

	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}
	
	public DBService() {
		// TODO Auto-generated constructor stub
		try {
			//JNDI(Java Naming Directory Interface)
			//����� ó���ϴ� ��ü
			InitialContext ic = new InitialContext();
			//�ڿ��˻�(Directory)=>Context��ġ
			Context ctx = (Context)ic.lookup("java:comp/env");
			//Context���� ��ϵ� �ڿ� �˻�
			ds = (DataSource) ctx.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
		
	}
	
	
	
}

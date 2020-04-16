package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyMain_DBTest2_sawon {

	//0���� : ojdbc14.jar(�ݵ���ؾߵȴ�)
	//        ojdbc50.jar ojdbc60.jar(���ص� �ȴ�)
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
		//1.Connection ������
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user		= "test";
		String password	= "test";
		Connection conn = DriverManager.getConnection(
				                        url, user, password);
				
		//2.SQL��� ó����ü ���
		//  SQL-> DDL DCL DML ��� SQL�� ó���Ѵ�
		Statement stmt = conn.createStatement();
		
		
		
		//3.�����ó����ü :ResultSet
		String sql   = "select * from sawon";
		ResultSet rs = stmt.executeQuery(sql);
		//��ü������ ��ȸ
		while(rs.next()) {
			//System.out.println("----");
			//���� rs�� ����Ű�� ��(���ڵ�)���� ��(�÷�) ����
			//                        heading
			int sabun		=	rs.getInt("sabun");
			String saname	=	rs.getString("saname");
			
			
			String sahire	=	rs.getString("sahire")
					              .substring(0, 10);
			
			
			System.out.printf("%d/%s/%s\n",sabun,saname,sahire);
		}
		
		//�ݱ�:���� ����
		rs.close();
		stmt.close();
		conn.close();	
			
		//SQL Injection(����): �������
		//Statement����
		String id="hong or 1=1 ",pwd="1234";
		String sql1 = 
		"select * from member where id=" + id + " and pwd=" + pwd;
		System.out.println(sql1);
		
		//PreparedStatment���� : ���ȼ�����
		String sql2 = "select * from member where id=? and pwd=?";
		
		
		
		

	}

}

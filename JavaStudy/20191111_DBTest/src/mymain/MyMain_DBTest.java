package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyMain_DBTest {

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
		System.out.println("--success connection--");
		
		//2.SQL���� ó����ü ���
		//  SQL-> DDL DCL DML ��� SQL�� ó���Ѵ�
		Statement stmt = conn.createStatement();
		
		//���̺�����
		//     DDL   
		//String sql = "create table ttt(no int)";
		//String sql = "drop table ttt";
		//        ���޵� sql���� ���� -> Oracle����
        //        ->Oracle����
		//        ->ó������� stmt�� �����ش� 
		
		
		//     DML
		//String sql = "insert into ttt values(1)";
		//String sql = "update ttt set no=100 where no=1";
		//String sql = "delete from ttt where no=100";
		//int res = stmt.executeUpdate(sql);
		//System.out.printf("ó���� ���:%d\n",res);
		
		
		//Statement  
		//  int res      = executeUpdate : Java -> DBMS�� �ִ��۾�(DML,DDL,DCL)
		//  ResultSet rs = executeQuery  : Java <- DBMS(select��)
		
		//3.�����ó����ü :ResultSet
		String sql   = "select deptno,loc,dname from dept";
		ResultSet rs = stmt.executeQuery(sql);
		//��ü������ ��ȸ
		while(rs.next()) {
			//System.out.println("----");
			//���� rs�� ����Ű�� ��(���ڵ�)���� ��(�÷�) ����
			//                        heading
			int    deptno = rs.getInt("deptno");
			String dname  = rs.getString("dname");
			String loc    = rs.getString("loc"); 
			
			/*
			//�������̸� ������� ����
			int    deptno = rs.getInt(1);
			String dname  = rs.getString(2);
			String loc    = rs.getString(3);
			*/ 
			
			System.out.printf("%d-%s-%s\n",deptno,dname,loc);
		}
		
		//�ݱ�:���� ����
		rs.close();
		stmt.close();
		conn.close();	
			
		

	}

}
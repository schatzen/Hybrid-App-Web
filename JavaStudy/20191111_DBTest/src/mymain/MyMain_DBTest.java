package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyMain_DBTest {

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
		System.out.println("--success connection--");
		
		//2.SQL명령 처리객체 얻기
		//  SQL-> DDL DCL DML 모든 SQL을 처리한다
		Statement stmt = conn.createStatement();
		
		//테이블생성
		//     DDL   
		//String sql = "create table ttt(no int)";
		//String sql = "drop table ttt";
		//        전달된 sql명령 수행 -> Oracle전달
        //        ->Oracle수행
		//        ->처리결과를 stmt로 돌려준다 
		
		
		//     DML
		//String sql = "insert into ttt values(1)";
		//String sql = "update ttt set no=100 where no=1";
		//String sql = "delete from ttt where no=100";
		//int res = stmt.executeUpdate(sql);
		//System.out.printf("처리된 행수:%d\n",res);
		
		
		//Statement  
		//  int res      = executeUpdate : Java -> DBMS로 넣는작업(DML,DDL,DCL)
		//  ResultSet rs = executeQuery  : Java <- DBMS(select문)
		
		//3.결과행처리객체 :ResultSet
		String sql   = "select deptno,loc,dname from dept";
		ResultSet rs = stmt.executeQuery(sql);
		//전체데이터 조회
		while(rs.next()) {
			//System.out.println("----");
			//현재 rs가 가리키는 행(레코드)에서 열(컬럼) 추출
			//                        heading
			int    deptno = rs.getInt("deptno");
			String dname  = rs.getString("dname");
			String loc    = rs.getString("loc"); 
			
			/*
			//가급적이면 사용하지 말것
			int    deptno = rs.getInt(1);
			String dname  = rs.getString(2);
			String loc    = rs.getString(3);
			*/ 
			
			System.out.printf("%d-%s-%s\n",deptno,dname,loc);
		}
		
		//닫기:열기 역순
		rs.close();
		stmt.close();
		conn.close();	
			
		

	}

}

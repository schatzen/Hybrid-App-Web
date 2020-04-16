package mymain;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.Properties;

public class MyMain_Properties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//속성정보저장관리(문자열기반)
		Properties prop = new Properties();
		//아래2개의 추가방법의 결과는 동일하다
		prop.put("id", "hong");         //객체형태
		prop.setProperty("pwd", "1234");//문자열형태
		
		String id = (String) prop.get("id");
		String pwd= prop.getProperty("pwd");
		
		System.out.printf("id=%s  pwd=%s\n",id,pwd);
		
		//화일로부터 DB접속정보 읽어오기
	
		try {
			Properties prop1 = new Properties();
			FileReader fr = new FileReader("db.properties");
			prop1.load(fr);
			
			String driver = prop1.getProperty("driver");
			String url    = prop1.getProperty("url");
			String user   = prop1.getProperty("user");
			       pwd    = prop1.getProperty("pwd");
			
			System.out.println(driver);
			System.out.println(url);
			System.out.println(user);
			System.out.println(pwd);
			
			//Properites의 key이름을 모를경우
			//열거형객체(보조객체): 키집합을 관리
			// key집합 :  driver  url  user  pwd
			Enumeration en =  prop1.keys();
			System.out.println("--Enumeration이용한 값읽기--");
			while(en.hasMoreElements()) {//관리요소가 있냐?
				
				String key = (String)en.nextElement();
				//System.out.println(key);
				String value = prop1.getProperty(key);
				System.out.printf("%s=>%s\n", key,value);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

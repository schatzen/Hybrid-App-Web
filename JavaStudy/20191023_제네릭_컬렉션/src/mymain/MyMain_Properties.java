package mymain;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.Properties;

public class MyMain_Properties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�Ӽ������������(���ڿ����)
		Properties prop = new Properties();
		//�Ʒ�2���� �߰������ ����� �����ϴ�
		prop.put("id", "hong");         //��ü����
		prop.setProperty("pwd", "1234");//���ڿ�����
		
		String id = (String) prop.get("id");
		String pwd= prop.getProperty("pwd");
		
		System.out.printf("id=%s  pwd=%s\n",id,pwd);
		
		//ȭ�Ϸκ��� DB�������� �о����
	
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
			
			//Properites�� key�̸��� �𸦰��
			//��������ü(������ü): Ű������ ����
			// key���� :  driver  url  user  pwd
			Enumeration en =  prop1.keys();
			System.out.println("--Enumeration�̿��� ���б�--");
			while(en.hasMoreElements()) {//������Ұ� �ֳ�?
				
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

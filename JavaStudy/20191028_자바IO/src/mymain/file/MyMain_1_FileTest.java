package mymain.file;

import java.io.File;

public class MyMain_1_FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("TestFolder");
		
		if(!file.exists()) {//�������� ������...����
			file.mkdir();
		}else {
			file.delete();
		}
		
		
		File f = new File("c:\\JavaStudy");
		//������� ��ȸ
		File [] f_array = f.listFiles();
		for(File ff : f_array) {
			String name = ff.getName();  //ȭ�ϸ�
			long   filelen = ff.length();//ȭ��ũ��(byte����)
			String   kind = "";
			if(ff.isDirectory())
				kind = "D";
			else if(ff.isFile())
				kind = "F";
			
			if(ff.isHidden())
				kind += "H";
			
			//if(ff.isAbsolute())
			//	kind += "A";
			
			System.out.printf("[%s] %s(%d)\n", kind,name,filelen);
		}
		
		//                  �θ���   ��������
		File del_f = new File( f ,  "back_del.jpg");
		if(del_f.exists()) {
			del_f.delete();
			System.out.println("����ȭ��:" + del_f);
			
		}
		
		
		System.out.println("--�Ϸ�--");
		
	}

}

package mymain.file;

import java.io.File;

public class MyMain_1_FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("TestFolder");
		
		if(!file.exists()) {//존재하지 않으면...생성
			file.mkdir();
		}else {
			file.delete();
		}
		
		
		File f = new File("c:\\JavaStudy");
		//하위목록 조회
		File [] f_array = f.listFiles();
		for(File ff : f_array) {
			String name = ff.getName();  //화일명
			long   filelen = ff.length();//화일크기(byte단위)
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
		
		//                  부모경로   하위파일
		File del_f = new File( f ,  "back_del.jpg");
		if(del_f.exists()) {
			del_f.delete();
			System.out.println("삭제화일:" + del_f);
			
		}
		
		
		System.out.println("--완료--");
		
	}

}

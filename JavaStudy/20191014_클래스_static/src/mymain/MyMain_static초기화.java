package mymain;

public class MyMain_static초기화 {

	//static 초기화
	static{
		System.out.println("0.무슨소리 내가 먼저 호출돼!!");
		//1.DB Driver Loading...
		//2.프로그램에 필요한 자원(Resource) 메모리 적재
		//  Resource: 이미지,사운드,....
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.내가 제일 먼저 호출돼!!");

	}
	
	static{
		System.out.println("0-1.무슨소리 내가 먼저 호출돼!!");
	}

}

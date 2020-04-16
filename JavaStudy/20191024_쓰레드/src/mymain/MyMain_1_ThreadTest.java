package mymain;

//쓰레드생성방법
//방법1: 관리+수행
//자식쓰레드/Sub Thread
class MyThread extends Thread
{
	
	public MyThread() {
		// TODO Auto-generated constructor stub
	}
	
	public MyThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println("Sub Thread : " + name);
	}
}
	
//방법2:쓰레드 수행객체 별도생성
class MyRunnable implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println("Sub Thread : " + name);
	}
}



public class MyMain_1_ThreadTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Primary Thread/메인(주)쓰레드/부모쓰레드
		String name = Thread.currentThread().getName();
		System.out.println("Main Thread : " + name);
		
		//메인쓰레드->자식쓰레드 생성
		Thread t1 = new MyThread("첫번째");
		//t1.setName("첫번째");//쓰레드명 부여
		t1.start();//일시작해라->Runnable(쓰레드대기방 이동)
		//t1.run();(X)
		
		//방법2
		Runnable r = new MyRunnable();//수행객체
		Thread t2 = new Thread(r,"두번째");    //관리객체
		t2.start();//대기방으로 이동
		
		//방법3(익명) : 방법1을 간소화
		Thread t3 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.println("Sub Thread : " + name);
			}
		};
		t3.setName("세번째");
		t3.start();
		
		//방법4: 방법2를 간소화
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.println("Sub Thread : " + name);
			}
		});
		t4.setName("네번째");
		//t4.setPriority(Thread.MAX_PRIORITY);
		t4.start();
		
		
		
		
		
	}

}

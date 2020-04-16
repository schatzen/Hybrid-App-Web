package mymain;

//스레드 생성 망법 
//방법 1 : 관리 + 수행
//자식스레드 / Sub Thread 
class MyThread extends Thread {

	public MyThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName(); // Thread. 안붙여도됨 currentThread가 Thread 메소드라 상관 x
		System.out.printf("Sub Thread : " + name);
	}

}

//방법2 : 스레드 수행객체 별도 생성
class MyRunnable implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName(); // Thread 붙여줘야 함
		System.out.printf("\r\nSub Thread : " + name);

	}

}

public class MyMain_1_ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Primary Thread 메인 (주) 스레드/부모스레드
		String name = Thread.currentThread().getName();
		System.out.println("\r\nMain.Thread : " + name);

		// 메인스레드 -> 자식스레드 생성
		Thread t1 = new MyThread("첫번째");
		t1.start(); // 일 시작해라 > Runnable(스레드 대기방 이동)
		// t1.run(); // run()으로 하면 sub이 아닌 main이 실행한 걸로 나옴 > 작업자를 따로 할당한 의미가 x

		// 방법2
		Runnable r = new MyRunnable(); // 수행객체
		Thread t2 = new Thread(r, "두번째"); // 관리객체 //Thread(수행, 이름) 이런 생성자도 있다.
		t2.start(); // 대기방으로 이동

		// 방법3 (익명) : 방법1을 간소화
		Thread t3 = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.printf("\r\nSub Thread : " + name);
			}
		};
		t3.setName("세번쨰");
		t3.start();

		// 방법4: 방법2를 간소화
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.printf("\r\nSub Thread : " + name);

			}
		});
		t4.setName("네번째");
		t4.setPriority(Thread.NORM_PRIORITY);
		t4.start();
	}

}

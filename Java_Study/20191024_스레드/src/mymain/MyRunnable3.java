package mymain;

public class MyRunnable3 implements Runnable {

	int money = 10000;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();

		while (true) {
			synchronized (this) {
				//조건부로 잠들어있는 스레드를 깨우기
				if (money >= 2000)
					notify();

				money -= 1000;

				System.out.printf("--[%s]먼저 (잔액 : %d)--\n", name, money);

				try {
					wait();
					Thread.sleep(1000);

				} catch (InterruptedException e) {

				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class MyMain_6_Starvation {
		public static void main(String[] args) {
			
		}
	}

}

package mymain;

//������ ���� ���� 
//��� 1 : ���� + ����
//�ڽĽ����� / Sub Thread 
class MyThread extends Thread {

	public MyThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName(); // Thread. �Ⱥٿ����� currentThread�� Thread �޼ҵ�� ��� x
		System.out.printf("Sub Thread : " + name);
	}

}

//���2 : ������ ���ఴü ���� ����
class MyRunnable implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName(); // Thread �ٿ���� ��
		System.out.printf("\r\nSub Thread : " + name);

	}

}

public class MyMain_1_ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Primary Thread ���� (��) ������/�θ𽺷���
		String name = Thread.currentThread().getName();
		System.out.println("\r\nMain.Thread : " + name);

		// ���ν����� -> �ڽĽ����� ����
		Thread t1 = new MyThread("ù��°");
		t1.start(); // �� �����ض� > Runnable(������ ���� �̵�)
		// t1.run(); // run()���� �ϸ� sub�� �ƴ� main�� ������ �ɷ� ���� > �۾��ڸ� ���� �Ҵ��� �ǹ̰� x

		// ���2
		Runnable r = new MyRunnable(); // ���ఴü
		Thread t2 = new Thread(r, "�ι�°"); // ������ü //Thread(����, �̸�) �̷� �����ڵ� �ִ�.
		t2.start(); // �������� �̵�

		// ���3 (�͸�) : ���1�� ����ȭ
		Thread t3 = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.printf("\r\nSub Thread : " + name);
			}
		};
		t3.setName("������");
		t3.start();

		// ���4: ���2�� ����ȭ
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.printf("\r\nSub Thread : " + name);

			}
		});
		t4.setName("�׹�°");
		t4.setPriority(Thread.NORM_PRIORITY);
		t4.start();
	}

}

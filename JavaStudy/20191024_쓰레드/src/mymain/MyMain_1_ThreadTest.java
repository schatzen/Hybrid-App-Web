package mymain;

//������������
//���1: ����+����
//�ڽľ�����/Sub Thread
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
	
//���2:������ ���ఴü ��������
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
		//Primary Thread/����(��)������/�θ𾲷���
		String name = Thread.currentThread().getName();
		System.out.println("Main Thread : " + name);
		
		//���ξ�����->�ڽľ����� ����
		Thread t1 = new MyThread("ù��°");
		//t1.setName("ù��°");//������� �ο�
		t1.start();//�Ͻ����ض�->Runnable(��������� �̵�)
		//t1.run();(X)
		
		//���2
		Runnable r = new MyRunnable();//���ఴü
		Thread t2 = new Thread(r,"�ι�°");    //������ü
		t2.start();//�������� �̵�
		
		//���3(�͸�) : ���1�� ����ȭ
		Thread t3 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.println("Sub Thread : " + name);
			}
		};
		t3.setName("����°");
		t3.start();
		
		//���4: ���2�� ����ȭ
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();
				System.out.println("Sub Thread : " + name);
			}
		});
		t4.setName("�׹�°");
		//t4.setPriority(Thread.MAX_PRIORITY);
		t4.start();
		
		
		
		
		
	}

}

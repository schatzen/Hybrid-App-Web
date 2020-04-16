package mymain;

//���ఴü
class MyRunnable2 implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		
		while(true) {
		
		   synchronized (this) 
		   {
			   //�����ִ� �����带 �����
			   notify();
			
			   System.out.printf("--[%s] ����!!--\n",name);
			   
			   try {
				   wait();//����
				   Thread.sleep(1000);
			   } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				   e.printStackTrace();
			   }
		   }
		}
	}
}

public class MyMain_5_Fairness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//������� ����(Fairness)�ϰ� ...
		
		Runnable r = new MyRunnable2();
        Thread t1 = new Thread(r,"����");
        Thread t2 = new Thread(r,"�ƿ�");
        
        t1.start();
        t2.start();
        
	}

}

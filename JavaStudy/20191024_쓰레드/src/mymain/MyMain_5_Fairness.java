package mymain;

//수행객체
class MyRunnable2 implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		
		while(true) {
		
		   synchronized (this) 
		   {
			   //잠들어있는 쓰레드를 깨우기
			   notify();
			
			   System.out.printf("--[%s] 먼저!!--\n",name);
			   
			   try {
				   wait();//잠들기
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
		
		//쓰레드는 공정(Fairness)하게 ...
		
		Runnable r = new MyRunnable2();
        Thread t1 = new Thread(r,"형님");
        Thread t2 = new Thread(r,"아우");
        
        t1.start();
        t2.start();
        
	}

}

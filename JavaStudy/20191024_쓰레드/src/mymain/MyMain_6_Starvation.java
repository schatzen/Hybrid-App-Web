package mymain;

//수행객체
class MyRunnable3 implements Runnable
{
	int money = 10000;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		
		while(true) {
		
		   synchronized (this) 
		   {
			   //조건부로 잠들어있는 쓰레드를 깨우기
			   if(money>=2000)
			       notify();
			
			   money -= 1000;
			   
			   System.out.printf("--[%s] 먼저(잔액:%d)!!--\n",
					                 name,     money);
			   
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

public class MyMain_6_Starvation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//쓰레드는 공정(Fairness)하게..
		//운영을 잘못하면 Starvation(기아)현상
		
		
		Runnable r = new MyRunnable3();
        Thread t1 = new Thread(r,"형님");
        Thread t2 = new Thread(r,"아우");
        
        t1.start();
        t2.start();
        
	}

}

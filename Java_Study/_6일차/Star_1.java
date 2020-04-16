class Star_1 
{
	public static void main(String[] args) throws Exception
	{

	
		// 별 열방향 찍기
/*
	for(int i = 4;i>=0;i--) {
		switch(i)
			{
				case 3 : System.out.print(" ");
				case 2 : System.out.print("  ");
				case 1 : System.out.print("   ");
				case 0 : System.out.print("    ");
			}
		for(int k=0;k<=i;k++) {
			
			System.out.print("*");
			Thread.sleep(100);
		}
		//줄 바꾸기
		System.out.println();
	}
*/

     for(int i = 0;i<5;i++) {
			for(int k=0;k<5;k++) {
			
			if(k<i)
			  System.out.print(" ");
            else 
			  System.out.print("*");

			
			Thread.sleep(10);
		}
		//줄 바꾸기
		System.out.println();
	} 


	}
}

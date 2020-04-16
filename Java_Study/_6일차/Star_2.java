class Star_2 
{
	public static void main(String[] args) throws Exception
	{
		for(int i=4;i>=0;i--) {
			for(int k=0;k<5;k++) {

				if(k < i)
				System.out.print(" ");
				else
				System.out.print("*");

				
			}
			Thread.sleep(100);
			System.out.println();
		}
	}
}

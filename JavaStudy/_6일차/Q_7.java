class Q_7
{
	public static void main(String[] args) 
	{
		System.out.println("Á¤¼ö°ª  Á¦°ö  ¼¼Á¦°ö");
		System.out.println("====================");
		for(int i=0;i<=5;i++){

			//System.out.printf("%d\t%d\t%d\n",i,i*i,i*i*i);

			System.out.printf("%d\t%d\t%d\n",
				               i,
				             (int)Math.pow(i,2),
			                 (int)Math.pow(i,3) );
		}
	}
}

class Q_6
{
	public static void main(String[] args) 
	{
		System.out.println("정상가격  세일가격");
        System.out.println("==================");
		for(int i=10000;i<=20000;i+=1000){
           //                   30% sale ->정상가*0.7 
           System.out.printf("%d\t%.1f\n",i,i*0.7);
		}
	}
}

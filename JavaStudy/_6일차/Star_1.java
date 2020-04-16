class Star_1
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("---전체출력---");
		for(int i=0;i<5;i++){
			//별 열방향 찍기
			for(int k=0;k<5;k++){
				System.out.print("*");
			}
			//줄바꾸기
			System.out.println();
		}

		System.out.println("---삼각형1---");
		for(int i=0;i<5;i++){
			//별 열방향 찍기
			for(int k=0;k<=i;k++){
				System.out.print("*");
			}
			//줄바꾸기
			System.out.println();
		}



	}
}

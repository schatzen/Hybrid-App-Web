import java.util.Scanner;

class Ex_DoWhile_1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String yn="y";//또할래?
        int dan;
		
		do{
			System.out.print("단?:");
			dan = scan.nextInt();

            //안되는 조건
			if(dan<2 || dan > 9){
                System.out.println("2~9사이값을 입력하세요");
				//반복문에서 현재 명령을 종료하고 
				//다음 제어식으로 이동해라
				continue;
			}

			System.out.printf("==[%d]단==\n",dan);
			for(int i=1;i<=9;i++){
               System.out.printf("%d x %d = %2d\n",dan,i,dan*i);
			}

			//또할지 말지에 대한 확인			
			System.out.print("또할래?(y/n):");
			yn = scan.next();// yn="y" or yn="Y"
            //문자열 비교는 equals()사용해야 된다 
		}while(yn.equals("y") || yn.equals("Y") );

		System.out.println("--End--");
	}
}

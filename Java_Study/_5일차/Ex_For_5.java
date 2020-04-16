import java.util.Scanner;

class Ex_For_5
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int dan;
		System.out.print("단?:");
		dan = scan.nextInt();

		//유효성체크(무효값이 들어오면 끝내라)
		//if( ! (dan>=2 && dan<=9) ){
        if( dan < 2 || dan > 9){
           System.out.println("dan은 2~9사이값을 입력하세요!!");
           return;// main method에 대한 제어권 반환(종료)
		}

		//옳바른값이 들어오면
		for(int i=1;i<=9;i++){ // i = 1 2 3 4 ... 9
			System.out.printf("%d x %d = %2d\n", 
				               dan,  i , dan*i);
		}






	}
}

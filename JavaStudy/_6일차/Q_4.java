import java.util.Scanner;

class Q_4
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1,su2;
		String op;
		int res = 0;
        
		System.out.print("2정수와 연산자를 입력하세요>>");
		su1 = scan.nextInt();
		op  = scan.next(); // + - * / %
		su2 = scan.nextInt();
		

		//if(op=="+") // (X)
		if(op.equals("+")){
            res = su1 + su2; 
		}else if(op.equals("-")){
            res = su1 - su2; 
		}else if(op.equals("*")){
            res = su1 * su2; 
		}else if(op.equals("/")){
            if(su2!=0)//젯수가 0 이 아니면 나누기해라
			  res = su1 / su2; 
		}else if(op.equals("%")){
            if(su2!=0)//젯수가 0 이 아니면 나누기해라
			  res = su1 % su2; 
		}
 
		if( su2==0 && (op.equals("/") || op.equals("%")) )
			System.out.println("--불능--");
		else
			System.out.printf("%d %s %d = %d\n",su1, op,su2,res);




	}
}

import java.util.Scanner;

class Q_4
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1,su2;
		String op;
		int res = 0;
        
		System.out.print("2������ �����ڸ� �Է��ϼ���>>");
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
            if(su2!=0)//������ 0 �� �ƴϸ� �������ض�
			  res = su1 / su2; 
		}else if(op.equals("%")){
            if(su2!=0)//������ 0 �� �ƴϸ� �������ض�
			  res = su1 % su2; 
		}
 
		if( su2==0 && (op.equals("/") || op.equals("%")) )
			System.out.println("--�Ҵ�--");
		else
			System.out.printf("%d %s %d = %d\n",su1, op,su2,res);




	}
}

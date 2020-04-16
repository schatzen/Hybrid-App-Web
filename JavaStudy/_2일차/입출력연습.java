//해당클래스의 위치정보 알려준다
import java.util.Scanner;


class 입출력연습 
{
	public static void main(String[] args) 
	{
        //표준출력장치: System.out
		//표준입력장치: System.in

        //각타입별 입력처리하는 객체 
		Scanner scan = new Scanner(System.in);

		String name;
		String addr;
		int    age;
		double ki;
		boolean bMarried;


		System.out.print("이름:"); // 홍길동(E)
		name = scan.nextLine();    //문자열입력받기(공백 / 엔터)
                                   // 
        System.out.print("나이:"); //20(E)
		age = scan.nextInt();

        System.out.print("키:"); //
		ki = scan.nextDouble();

        System.out.print("결혼유무:"); //
		bMarried = scan.nextBoolean();


		//키보드버퍼의 엔터값을 가져다 버린다
		scan.nextLine();


        System.out.print("주소:");
		addr = scan.nextLine();//문자열입력받기(엔터)




		System.out.println(name);
		System.out.println(age);
		System.out.println(ki);
		System.out.println(bMarried);
		System.out.println(addr);





		
	}
}

import java.util.Scanner;

class 문제3
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double  radius;
        
		double  circle_round=0.0;  //원둘레
		double  circle_area=0.0; //원면적
		double  circle_volume=0.0; //원부피

        System.out.print("반지름:");
		radius = scan.nextDouble();

        //계산
	    circle_round = 2 * Math.PI * radius;	
        circle_area  = radius * radius * Math.PI;
        circle_volume= 4.0/3.0 * Math.PI * radius * radius * radius;
		

        System.out.println("***결과***");
		System.out.printf("원둘레:%.2f(cm)\n", circle_round);
		System.out.printf("원면적:%.2f(㎠)\n", circle_area);
		System.out.printf("원체적:%.2f(㎤)\n", circle_volume);

         



	}
}

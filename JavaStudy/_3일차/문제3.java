import java.util.Scanner;

class ����3
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double  radius;
        
		double  circle_round=0.0;  //���ѷ�
		double  circle_area=0.0; //������
		double  circle_volume=0.0; //������

        System.out.print("������:");
		radius = scan.nextDouble();

        //���
	    circle_round = 2 * Math.PI * radius;	
        circle_area  = radius * radius * Math.PI;
        circle_volume= 4.0/3.0 * Math.PI * radius * radius * radius;
		

        System.out.println("***���***");
		System.out.printf("���ѷ�:%.2f(cm)\n", circle_round);
		System.out.printf("������:%.2f(��)\n", circle_area);
		System.out.printf("��ü��:%.2f(��)\n", circle_volume);

         



	}
}

//�ش�Ŭ������ ��ġ���� �˷��ش�
import java.util.Scanner;


class ����¿��� 
{
	public static void main(String[] args) 
	{
        //ǥ�������ġ: System.out
		//ǥ���Է���ġ: System.in

        //��Ÿ�Ժ� �Է�ó���ϴ� ��ü 
		Scanner scan = new Scanner(System.in);

		String name;
		String addr;
		int    age;
		double ki;
		boolean bMarried;


		System.out.print("�̸�:"); // ȫ�浿(E)
		name = scan.nextLine();    //���ڿ��Է¹ޱ�(���� / ����)
                                   // 
        System.out.print("����:"); //20(E)
		age = scan.nextInt();

        System.out.print("Ű:"); //
		ki = scan.nextDouble();

        System.out.print("��ȥ����:"); //
		bMarried = scan.nextBoolean();


		//Ű��������� ���Ͱ��� ������ ������
		scan.nextLine();


        System.out.print("�ּ�:");
		addr = scan.nextLine();//���ڿ��Է¹ޱ�(����)




		System.out.println(name);
		System.out.println(age);
		System.out.println(ki);
		System.out.println(bMarried);
		System.out.println(addr);





		
	}
}

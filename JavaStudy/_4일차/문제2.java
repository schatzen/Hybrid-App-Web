import java.util.Scanner;

class ����2
{
	public static void main(String[] args) 
	{
		/*
		     [�Է�]
             �ֹ�(�ݶ�:1000  Ŀ��:1500  �꽺:2000):�ݶ�
			 ����:3
			 �ݾ�:10000
			 
			 [���]
			 ����ǰ��:�ݶ�
			 �ѱ��Աݾ�:3000
			 �ΰ���(10%):300
			 �ܾ�:6700
		*/
        Scanner scan = new Scanner(System.in);
		//�Է¿� �ʿ��� ����
		String drink_name;
		int    drink_price;
		int    count;
		int    money;

		//��¿� �ʿ��� ����
        int total_money; //�Ѿ� = �ܰ� * ����;
		int tax; //�ΰ���
        int remain_money;//�ܾ�  


        System.out.println("====[�Է�]====");
		System.out.print("�ֹ�(�ݶ�:1000 Ŀ��:1500 �꽺:2000):");
		drink_name = scan.next();
        System.out.print("����:");
		count = scan.nextInt();
		System.out.print("�ݾ�:");
		money = scan.nextInt();

		//����ܰ� ���ϱ�
        switch(drink_name)
		{
           case "�ݶ�": drink_price = 1000;break;
           case "Ŀ��": drink_price = 1500;break;
           case "�꽺": drink_price = 2000;break;
		   default: drink_price = 0;
		}

        //��� ���
		total_money = drink_price * count;//�Ѿ�
		tax = (int)(total_money * 0.1);//�ΰ���
		remain_money = money - (total_money+tax);

		System.out.println("====[���]====");
		System.out.printf("����ǰ��:%s\n",drink_name);
		System.out.printf("�ѱ��Ծ�:%d(��)\n",total_money);
		System.out.printf("�ΰ���(10%%):%d(��)\n",tax);
		System.out.printf("�Ž�����:%d(��)\n",remain_money);

        


		
	}
}

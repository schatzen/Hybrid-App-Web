class Ex_Method1
{
	public static void main(String[] args) 
	{
		//class MyMath ��ü ����
		MyMath mm = new MyMath();

		 int x = 15, y = 3, z = 12;
		 double d1=10.0, d2=3.0, d3;
		 int res;

		//plus(int,int)ȣǮ�� �޼ҵ� �� + ��������
		//int�� plus�޼ҵ� ȣ��
		res = mm.plus(x,y);
		System.out.printf("%d + %d = %d\n",x,y,res);

		//double�� plus�޼ҵ� ȣ��
		d3 = mm.plus(d1,d2);
		System.out.printf("%.1f + %.1f = %.1f\n",d1,d2,d3);

		//���� ���
		res = mm.minus(x,y);
		System.out.printf("%d - %d = %d\n",x,y,res);

		//ū �� ���ϱ� ���
		res = mm.max(x,y);
		System.out.printf("%d��(��) %d�� �� ū ���� %d�Դϴ�.\n",x,y,res);	

		res = mm.max(x,y,z);
		System.out.printf("%d��(��) %d��(��) %d �� �� ū ���� %d�Դϴ�.\n",x,y,z,res);	

		//x������ ��
		res = mm.hap(x);
		System.out.printf("1~%d������ ���� %d�Դϴ�.\n",x,res);
	}
}

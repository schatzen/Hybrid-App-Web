
public class Ex_Method1
{
	public static void main(String[] args) 
	{

		// class MyMath��ü ����
		MyMath mm = new MyMath();
  
        int x = 10, y = 5,res;
		double d1=10.0,d2=3.0,d3;
		//    plus(int,int)ȣ��� �޼ҵ��+��������
		res = mm.plus(x,y);
		System.out.printf("%d + %d = %d\n",x,y,res);

		d3 = mm.plus(d1,d2);
		System.out.printf("%.1f + %.1f = %.1f\n",d1,d2,d3);



		//������ �̿�
		res = mm.minus(x,y);
		System.out.printf("%d - %d = %d\n",x,y,res);

		//ū�� ���ϱ�
		res = mm.max(x,y);
		System.out.printf("%d��(��) %d���� ū���� %d\n",x,y,res);

        // x������ ��
		res = mm.hap(x);
	    System.out.printf("1~%d������ ��=%d\n",x,res);

		//3���� ū��
		int a = 10,b=2,c=7;
		res = mm.max(a,b,c);
 
        System.out.printf("%d,%d,%d���� ����ū�� %d\n",a,b,c,res);

	}
}

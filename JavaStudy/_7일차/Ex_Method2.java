class Ex_Method2
{
	/*
       Methodȣ���Ŀ� ���� �з�
	   1.Call By Name(�̸��� �̿��ؼ� ȣ��)
	   2.Call By Value(�̸�+����(Value) �̿��ؼ� ȣ��)
	   3.Call By Reference(�̸�+����(��������) �̿��ؼ� ȣ��)
	*/
	public static void main(String[] args) 
	{
		//���׸��� ��ü ����
		MyLine ml = new MyLine();
	    int line_len = 40;//������

		System.out.printf("%22s\n","===[��������]===");
		//System.out.println("----------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('=',line_len);

		System.out.println(" ��ȣ  �̸�  ���� ���� ����  ����  ���");
		//System.out.println("----------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('=',line_len);
		System.out.println("  1   �ϱ浿  99   89   98   297    96");
		System.out.println("  2   �̱浿  99   89   98   289    97");
		System.out.println("  3   ��浿  99   89   98   296    98");
		//System.out.println("----------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('*',2,'-',2,line_len);
		// *---*---*---*---*---*---*---*---*---*---*---*---
		// **--**--**--**--**--**--**--**--**--**--**--**--

		
	}
}

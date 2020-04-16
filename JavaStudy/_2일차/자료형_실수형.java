class �ڷ���_�Ǽ��� 
{
	public static void main(String[] args) 
	{
		//�Ǽ�   : �Ҽ����� �ִ� ��
		//�Ǽ��� : float  double(�⺻��)
		//���   : 1.0   1.0F (float) 
		//         1.234E+4 (����)  1.234FE+4
		//��¼���: 
		//           %f       <=�Ҽ������� 6�ڸ� �⺻���
		//           %e(����) <=�Ҽ������� 6�ڸ� �⺻���
		//           %g       <=�ڸ����� ���������� ���

		double d = 123.4567891234;
		System.out.printf("%f\n",d);
		System.out.printf("%e\n",d);
		System.out.printf("%E\n",d);
		System.out.printf("%g\n",d);

		//������� : %m.nf
		//            m : ��ü����ڸ���(����)
		//            n : �Ҽ��������ڸ��� 
		System.out.printf("[%10.3f]\n",d); //right align
		System.out.printf("[%-10.3f]\n",d);//left  align
		System.out.printf("[%010.3f]\n",d);//���ʺ���� 0����ä���

		// Ȯ�����ڸ��� < ����ڸ��� => Ȯ���ڸ��� ����
		System.out.printf("[%5.3f]\n",d);
		System.out.printf("[%.3f]\n",d);

		//float���� double���� ���е� Ȯ��
		System.out.printf("%.20f\n",1.2345678901234567890F);
		System.out.printf("%.20f\n",1.2345678901234567890);
















	}
}

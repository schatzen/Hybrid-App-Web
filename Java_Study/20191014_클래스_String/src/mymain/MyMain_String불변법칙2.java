package mymain;

public class MyMain_String�Һ���Ģ2 {

	public static void main(String[] args) {
		// ���: �ڹٿ����� ���ڿ� ������ �Ʒ��� ���� ���� �� ��
		// ����: �޸� ���� �����ϰ� �߻�

		int count = 0;
		String msg = ++count + " little." + 
					 ++count + " little." + 
					 ++count + " little Indian";
		System.out.println(msg);
		System.out.println(msg.length());
		
		//�ذ��� 1.StrungBuffer(�⺻������ 16���� ����)
		count = 0;
		StringBuffer sb = new StringBuffer();
		//StringBuffer sb = new StringBuffer(33); //>�����ε�� ��

		sb.append(++count); //append�� ��� �߰��Ѵٴ� �ǹ�
		sb.append(" little.");
		sb.append(++count);
		sb.append(" little.");
		sb.append(++count);
		sb.append(" little Indian");
		
		//StringBuffer���� ���� String���� ��ȯ�޴´�.
		String msg1 = sb.toString();
		System.out.println(msg1);
		System.out.println(msg1.length());
		
		//�ذ��� 2. String.format("��¼���",��) : JDK1.5 ���ĺ��� ����
		count = 0;
		String msg2 = String.format("%d little.%d little.%d little Indian", 
				++count,++count,++count); //static�޼ҵ�
		
		System.out.println(msg2);
		System.out.println(msg2.length());
		
		
	}

}

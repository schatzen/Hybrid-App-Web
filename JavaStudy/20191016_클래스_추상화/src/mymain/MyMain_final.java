package mymain;

/*
 
 final
 1.����:  final �ڷ��� ������=��;
          (�������)  
 2.�޼ҵ�: final �ڷ��� �޼ҵ��()
          (���̻� ������ ���� ���ƶ�)  
 3.Ŭ����: final class Ŭ����          
          (������� ���ƶ�)  
 */

class A{
	void sub() {}
	final void sub1() {}
}

final class B extends A{
	void sub() {}
	//void sub1() {} // final method�̱⶧���� ������ �Ұ�
}

// class C extends B{}
// class MyString extends String {}



public class MyMain_final {
	//�������
    public final static String PROGRAM_NAME ="final ����";
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(MyMain_final.PROGRAM_NAME); 
        //MyMain_final.PROGRAM_NAME= "���� final";
	}

}

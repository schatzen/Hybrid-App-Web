package mymain;

class A extends Object{}

class B extends A{}

class C extends B{
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Object->A->B->C상속구조를 갖는 객체";
	}
}

class D{
	
	public D() {
		// TODO Auto-generated constructor stub
	}
	
	
}

public class MyMain_instanceOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Object c = new C();
        //Object객체를 포함하고 있냐?
        System.out.println( c instanceof Object);
        System.out.println( c instanceof A);
        System.out.println( c instanceof B);
        System.out.println( c instanceof C);
        //System.out.println( c instanceof D);
        
        System.out.println(c);
        
        
	}

}

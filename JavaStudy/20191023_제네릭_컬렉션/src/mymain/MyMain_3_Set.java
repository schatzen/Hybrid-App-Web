package mymain;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MyMain_3_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�������� ����Ǵ� �����ͱ���
		// HashSet(������������)
		// TreeSet(�����ؼ�����)
		Set<String> set = new TreeSet<String>();
		
		set.add("�浿3");
		set.add("�浿4");
		set.add("�浿5");
		set.add("�浿1");
		set.add("�浿2");
		
		//�ߺ������� ����ȵȴ�
		if(set.add("�浿5")==false)
			System.out.println("--�߰�����--");
		
		
	    System.out.println(set);
	    
	    System.out.println("--���� loop�̿�--");
	    for(String name : set) {
	    	System.out.println(name);
	    }
	    
	    
	    //Iterator: �ݺ���(�÷��� ������ü)
	    System.out.println("--Iterator �̿�--");
	    //set =>[�浿1, �浿2, �浿3, �浿4, �浿5]
	    Iterator<String> it = set.iterator();
	    while(it.hasNext()) {//it���� ������ �ֳ�?
	    	String name = it.next();//��������
	    	System.out.println(name);
	    }
	    
	    
	    
		
		
	}

}

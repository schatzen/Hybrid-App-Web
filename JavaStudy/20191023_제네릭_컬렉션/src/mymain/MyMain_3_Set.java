package mymain;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MyMain_3_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//순서없이 저장되는 데이터구조
		// HashSet(순서없이추출)
		// TreeSet(정렬해서추출)
		Set<String> set = new TreeSet<String>();
		
		set.add("길동3");
		set.add("길동4");
		set.add("길동5");
		set.add("길동1");
		set.add("길동2");
		
		//중복데이터 저장안된다
		if(set.add("길동5")==false)
			System.out.println("--추가실패--");
		
		
	    System.out.println(set);
	    
	    System.out.println("--개선 loop이용--");
	    for(String name : set) {
	    	System.out.println(name);
	    }
	    
	    
	    //Iterator: 반복자(컬렉션 보조객체)
	    System.out.println("--Iterator 이용--");
	    //set =>[길동1, 길동2, 길동3, 길동4, 길동5]
	    Iterator<String> it = set.iterator();
	    while(it.hasNext()) {//it값을 가지고 있냐?
	    	String name = it.next();//가져오기
	    	System.out.println(name);
	    }
	    
	    
	    
		
		
	}

}

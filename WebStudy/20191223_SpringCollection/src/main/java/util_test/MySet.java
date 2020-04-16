package util_test;

import java.util.Set;

public class MySet {

	//SpringÀÌ Injection(ÁÖÀÔ)
	Set  set;
	
	public MySet() {
		// TODO Auto-generated constructor stub
	}

	public MySet(Set set) {
		super();
		this.set = set;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
	
	
	
	
	
	
}

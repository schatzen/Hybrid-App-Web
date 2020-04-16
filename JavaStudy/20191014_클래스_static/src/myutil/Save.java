package myutil;

public class Save {

	String name;
	int    money;
	//정적변수(공유변수)
	public static double rate;
	
	//기본생성자
	public Save() {
		// TODO Auto-generated constructor stub
	}
	
	public Save(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}


	public void display() {
		
		System.out.printf("[%s-%d-%.2f-%d]\n",
				          this.name,  //저축자명
				          this.money, //저축액
				          Save.rate,  //이율
				          (int)(this.money*rate) //이자
				          
				);
		
	}
}

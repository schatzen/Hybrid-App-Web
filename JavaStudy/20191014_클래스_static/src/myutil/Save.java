package myutil;

public class Save {

	String name;
	int    money;
	//��������(��������)
	public static double rate;
	
	//�⺻������
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
				          this.name,  //�����ڸ�
				          this.money, //�����
				          Save.rate,  //����
				          (int)(this.money*rate) //����
				          
				);
		
	}
}

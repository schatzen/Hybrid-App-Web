package mymain;

public class CollisionManager {

	DungManager dungManager;
	MyMain_�����ϱ� main;
	
	public CollisionManager() {
		// TODO Auto-generated constructor stub
	}

	public CollisionManager(DungManager dungManager, MyMain_�����ϱ� main) {
		super();
		this.dungManager = dungManager;
		this.main = main;
	}
	
	public void collision_me_dung() {
	
		for(Dung dung : dungManager.dung_list) {
			
			//�浹�Ǿ����� ����
			if(main.me.pos.intersects(dung.pos)) {
				dungManager.dung_list.remove(dung);
				main.collision_count++;
				return;
			}
		}
		
	}
	
	
	
	
	
	
	
}

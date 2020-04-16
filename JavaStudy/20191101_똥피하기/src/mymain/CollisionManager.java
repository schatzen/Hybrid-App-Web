package mymain;

public class CollisionManager {

	DungManager dungManager;
	MyMain_똥피하기 main;
	
	public CollisionManager() {
		// TODO Auto-generated constructor stub
	}

	public CollisionManager(DungManager dungManager, MyMain_똥피하기 main) {
		super();
		this.dungManager = dungManager;
		this.main = main;
	}
	
	public void collision_me_dung() {
	
		for(Dung dung : dungManager.dung_list) {
			
			//충돌되었으면 삭제
			if(main.me.pos.intersects(dung.pos)) {
				dungManager.dung_list.remove(dung);
				main.collision_count++;
				return;
			}
		}
		
	}
	
	
	
	
	
	
	
}

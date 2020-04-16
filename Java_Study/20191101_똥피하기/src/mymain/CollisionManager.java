package mymain;

public class CollisionManager {

	DungManager dungManager;
	MyMain_똥피하기 main;

	public CollisionManager(DungManager dungManager, MyMain_똥피하기 main) {
		this.dungManager = dungManager;
		this.main = main;

	}

	public void collision_me_dung() {
		for (Dung dung : dungManager.dungList) {

			// 충돌되었으면 삭제
			if (main.me.pos.intersects(dung.pos)) {
				dungManager.dungList.remove(dung);
				main.collision_count++;
				return;

			}

		}
	}

}

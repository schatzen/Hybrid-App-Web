package mymain;

public class CollisionManager {

	DungManager dungManager;
	MyMain_�����ϱ� main;

	public CollisionManager(DungManager dungManager, MyMain_�����ϱ� main) {
		this.dungManager = dungManager;
		this.main = main;

	}

	public void collision_me_dung() {
		for (Dung dung : dungManager.dungList) {

			// �浹�Ǿ����� ����
			if (main.me.pos.intersects(dung.pos)) {
				dungManager.dungList.remove(dung);
				main.collision_count++;
				return;

			}

		}
	}

}

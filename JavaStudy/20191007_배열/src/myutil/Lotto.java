package myutil;

import java.util.Random;

public class Lotto {

	Random rand  = new Random();
	
	public void make_lotto(int [] ar) {
        //�ζǹ�ȣ 6�ڸ� �ֱ�
		//�ߺ��� ����
		for(int i=0;i<ar.length;i++) {
			int su = rand.nextInt(45) + 1;
			
			boolean bExist=false;//�����ϳ�?
			//�ߺ��� üũ(���� i ���������� üũ)
			for(int k=0;k<i;k++) {
				if(su==ar[k]) {//�������� �ֳ�?
					bExist=true;//�������� ������
					break;
				}
			}
			
			if(bExist) {//���ϼ��� �߻�������..
				i--;
			}else {
			  ar[i] = su;
			}
		}
		
		
	}
}

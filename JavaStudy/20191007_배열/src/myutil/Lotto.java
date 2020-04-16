package myutil;

import java.util.Random;

public class Lotto {

	Random rand  = new Random();
	
	public void make_lotto(int [] ar) {
        //로또번호 6자리 넣기
		//중복수 배제
		for(int i=0;i<ar.length;i++) {
			int su = rand.nextInt(45) + 1;
			
			boolean bExist=false;//존재하냐?
			//중복수 체크(현재 i 이전값까지 체크)
			for(int k=0;k<i;k++) {
				if(su==ar[k]) {//같은수가 있냐?
					bExist=true;//같은수가 있으면
					break;
				}
			}
			
			if(bExist) {//동일수가 발생했으면..
				i--;
			}else {
			  ar[i] = su;
			}
		}
		
		
	}
}

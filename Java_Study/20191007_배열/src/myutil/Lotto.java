package myutil;

import java.util.Random;

public class Lotto {
	
	
	Random rand = new Random();
	
	public void make_lotto(int [] ar) {
		//로또번호 6자리 넣기
		//중복수 배제
		//
		
		
		
			//ar[i] = rand.nextInt(45)+1;
			for (int i = 0; i < ar.length-1; i++) { // 기준값
				ar[i] = rand.nextInt(45)+1;
				for (int k = i + 1; k < ar.length; k++) {
					ar[k] = rand.nextInt(45)+1;				
					if (ar[k] == ar[i]) {
						
						while(ar[k] !=ar[i]) {
							ar[k] = rand.nextInt(45)+1;
						}
						}
						
					} 
						
					
			
			
			
			//중복수 체크
		}
		
	
	}
	}
// boolean bExist = false;




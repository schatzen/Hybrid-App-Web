package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	//추첨번호
	int [] win_no; //7자리
	int [] user_no;//사용자 입력한 숫자
	int count = 0;//맞은갯수
	int rank  = 0;//등수
	
	Random rand = new Random(); 
	
	//추첨
	public void make_win_no() {
		win_no = new int[7];
		
		OUT_FOR: // Label 
		for(int i=0;i< win_no.length;i++) {
			
			int su = rand.nextInt(45)+1;//1~45
			
			//중복수 체크
			for(int k=0;k<i;k++) {
				//같은수가 있으면
				if(su==win_no[k]) {
					i--;
					// 바깥for문의 증감식으로 이동(i++)
					continue OUT_FOR;
				}
			}
			win_no[i] = su;
		}
		
		//마지막 번호를 제외한 앞에 6자리 숫자 정렬
		//            0 1 2 3 4 5  6
		// win_no  = [1 3 5 6 7 9] 2
		Arrays.sort(win_no, 0, 0+6);
			
	}
	
	
	public void setUser_no(int[] user_no) {
		this.user_no = user_no;
		
		//맞은갯수 및 등수체크
		calc_rank();
	}
	
	private void calc_rank() {
		// TODO Auto-generated method stub
		count = 0;
		rank  = 0;
		//맞은갯수 계산하기
		for(int i=0;i<6;i++) {
			for(int k=0;k<6;k++) {
				if(user_no[i]==win_no[k]) {
					count++;
					break;
				}
			}
		}
		
		//등수계산하기
		if(count==6) rank=1;
		else if(count==5) rank=3;
		else if(count==4) rank=4;
		else if(count==3) rank=5;
		
		//3등 중에서 보너스번호 맞은것이 2등
		if(count==5) {
			for(int i=0;i<6;i++) {
				if(user_no[i]==win_no[6]) {
					rank=2;
					break;
				}
			}
		}
		
	}


	public void display() {
		//추첨번호 출력
		System.out.print("당첨번호:");
		for(int i=0;i<win_no.length;i++) {
			if(i<6)
			    System.out.printf("%3d",win_no[i]);
			else
				System.out.printf(" [%3d]\n",win_no[i]);
		}
		
		//유저번호 정렬
		Arrays.sort(user_no);
		System.out.print("유저번호:");
		
		for(int i=0;i<user_no.length;i++) {
		    System.out.printf("%3d",user_no[i]);
		}
		System.out.println();
		
		
		System.out.printf("맞은갯수:%d(개)\n",count);
		if(rank==0)
			System.out.println("꽝!!");
		else
		    System.out.printf("등수:%d(등)\n",rank);
		
	}
	
	
}

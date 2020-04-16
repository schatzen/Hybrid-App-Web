package myutil;

public class Mabangjin {

	int chasu;
	int [][] mabang;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//마방진 생성
		this.make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		//마방진을 구성할 배열 생성
		mabang = new int[chasu][chasu];
		
		int row = 0;
		int col = chasu/2;
		int su  = 1;
		
		//첫번째칸 값을 채우기
		mabang[row][col] = su++;
		
		//채우기
		for(int i=0;i<chasu*chasu-1;i++) {
			//대각으로 이동
			row--;
			col++;
			
			//윗쪽 오른쪽 모두 나간경우
			// =>이전위치에서 아래로 이동
			if(row < 0 && col==chasu) {
				row+=2;//아래로 2칸
				col--; //왼쪽   1칸
			}else if(row < 0) { //위로 나간경우
				                // => 맨 아래로 이동 
				row = chasu-1; 
				
			}else if(col==chasu) { //오른쪽으로 나간경우
				                   // => 맨 앞으로 이동  
				col = 0;
			}
			
			//이미 값이 채워져 있냐?
			// => 이전위치의 바로 아래로 이동
			if(mabang[row][col] != 0) {
				row+=2;//아래로 2칸
				col--; //왼쪽   1칸
			}
			
			//값채우기
			mabang[row][col] = su++;
			
		}
		
		
	}

	public void display() {
		// TODO Auto-generated method stub
		
		//열합계
		int [] col_sum = new int[chasu];
		
		int diagonal2_sum = 0;
		
		for(int i=0;i<chasu;i++) {
			int row_sum = 0;//행합계
			for(int k=0;k<chasu;k++) {
				System.out.printf("%4d",mabang[i][k]);
				row_sum += mabang[i][k];
				
				col_sum[k] += mabang[i][k];
				
				//역대각의 합
				if(i==k)
					diagonal2_sum += mabang[i][k];
			}
			System.out.printf("%4d",row_sum);
			
			System.out.println();//줄바꾸기
		}
		
		
		//열합계 출력
		for(int k=0;k<chasu;k++) {
			System.out.printf("%4d",col_sum[k]);
		}
		
		//역대각합 출력
		System.out.printf("%4d",diagonal2_sum);
		
		System.out.println();//줄바꾸기
		
		
	}
	
	
	
	
}

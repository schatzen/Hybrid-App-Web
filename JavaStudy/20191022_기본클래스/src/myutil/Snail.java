package myutil;

public class Snail {

	//방향 상수
	public static final int RIGHT = 1;
	public static final int DOWN  = 2;
	public static final int LEFT  = 3;
	public static final int UP    = 4;
	
	//방향상태를 저장할 변수
	int direction;
	
	int row_count;
	int col_count;
	int [][] snail_array;
	
	public void setData(int row_count,int col_count) {
		this.row_count = row_count;
		this.col_count = col_count;
		
		//달팽이 생성
		make_snail();
	}

	private void make_snail() {
		// TODO Auto-generated method stub
		snail_array = new int[row_count][col_count];
		
		//여기에 구현
		
		direction = RIGHT;
		int row = 0;
		int col = -1;
		
		//for(int i=1; i<=row_count*col_count;i++) {
		for(int i=row_count*col_count; i>0;i--) {
			if(direction==RIGHT) {
				col++;
				
				if( (col==col_count) || (snail_array[row][col]!=0) ){
				   col--;//이전위치로 돌아오고
				   row++;//아래로 이동하고
				   direction=DOWN;//방향바꾸기
				}
				
			}else if(direction==DOWN) {
				row++;
				if( (row==row_count) || (snail_array[row][col]!=0) ){
					row--;
					col--;
					direction=LEFT;
				}
			}else if(direction==LEFT) {
				col--;
				if( (col<0) || (snail_array[row][col]!=0) ){
					row--;
					col++;
					direction=UP;
				}
			}else if(direction==UP) {
				row--;
				if((snail_array[row][col]!=0) ){
					row++;
					col++;
					direction=RIGHT;
				}
			}
			
			snail_array[row][col]=i;
		}
		
		
		
	}
	
	public void display() {
		
		for(int i=0;i< row_count;i++) {
			for(int k=0;k<col_count;k++) {
				
				System.out.printf("%4d", snail_array[i][k]);
			}
			System.out.println();//줄바꾸기
		}
		
	}
	
	
	
	
	
}

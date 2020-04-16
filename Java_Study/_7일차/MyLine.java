class MyLine 
{

	//1. Call By Nme : 호풀시 메소드명만 호출
	public void draw_line() {
		System.out.println("------------------------------");
		return; 

				//(생략가능) 자신을 호출한 곳으로 복귀해라
				// return 0; 으로 바꾸려면 void 대신 int로 바꿔야한다. 
				// retrun 0.0; 으로 바꾸려면 int 대신 double로 바꿔야한다.
				// return 0; 일때 double draw_line();해도 괜찮음. 형변환됨.
				// void는 반환할 자료형이 없다는 뜻
	}

	//2. Call By Value : 호출시 호출인자도 같이 넘겨서 이용
	public void draw_line(int len) {

		for(int i=0;i<len;i++){
		System.out.print('-');
		}

		System.out.println();
	}

	public void draw_line(char style,int len, int len1) {

		for(int i=0;i<len1;i++){
		for(i=0;i<len;i++){
		System.out.print(style);
		}
		}
		System.out.println();
	}

	public void draw_line(char style1, int len1, char style2, int len2, int total_len) {

//				for(int i=1;i<=total_len/(len1+len2);i++) {
//
//					for(int k=1;k<=len1;k++) {
//					System.out.print(style1);
//					}
//
//					for(int j=1;j<=len2;j++) {
//					System.out.print(style2);
//					
//						}
//							}
//							System.out.println();	

			// 출력한 갯수 저장할 변수
			int count =0;
			while(true) {

				//pattern1 출력
				for(int i=0; i<len1; i++) {
				System.out.print(style1);
				count ++; 

					if(count==total_len){
					System.out.println();
					return;//현재 메소드 종료
					}

						 //현재 메소드 종료
				}

				//pattern2 출력
				for(int i=0; i<len2; i++) {
				System.out.print(style2);
				count ++; 

				if(count==total_len){
					System.out.println();
					return;
					}
						
			}
		}
	}
}


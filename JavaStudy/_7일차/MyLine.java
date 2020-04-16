class MyLine
{
	//Call By Name : 호출시 메소드명만 이용
	public void draw_line(){
		System.out.println("----------------------------------");
		return; //(생략가능) 자신을 호출한 곳으로 복귀해라
	}

    //Call By Value : 호출시 호출인자도 같이넘겨서 호출
	public void draw_line(int len){

        for(int i=0;i<len;i++){
		   System.out.print('-');
		}

		System.out.println();//줄바꾸기
	}

    //Call By Value : 호출시 호출인자도 같이넘겨서 호출
	public void draw_line(char style,int len){

        for(int i=0;i<len;i++){
		   System.out.print(style);
		}

		System.out.println();//줄바꾸기
	}

    // ml.draw_line('*',1,'-',3,40);
    // *---*---*---*---*---*---*---*---*---*---*---*---
	// ml.draw_line('*',2,'-',2,40);
	// **--**--**--**--**--**--**--**--**--**--**--**--
	// ml.draw_line('#',3,'@',2,40);
	// ###@@###@@###@@###@@###@@###@@###@@###@@###@@###
	public void draw_line(
		        char style1,int len1,//pattern1정보 
		        char style2,int len2,//pattern2정보
		        int total_len){      //전체선길이
          
		  //출력한 갯수저장할 변수
		  int count = 0;
		  while(true){
              //pattern1출력
			  for(int i=0;i<len1;i++){
                 System.out.print(style1);
				 count++;
				 //지정된 길이만큼 출력했으면
                 if(count==total_len){
				     System.out.println();	 
					 return;//(현재 메소드 종료)
				 }
			  }
			  //pattern2출력
			  for(int i=0;i<len2;i++){
                 System.out.print(style2);
				 count++;
                 //지정된 길이만큼 출력했으면
                 if(count==total_len){
				     System.out.println();	 
					 return;//(현재 메소드 종료)
				 }
			  }
		  }

	}



}

class Ex_Method2 
{
		/*
		Method 호출방식에 따른 분류
		1. Call By Name		 : 이름만 이용해서 호출
		2. Call By Value	 : 이름 + 인자(Value) 이용해서 호풀
		3. Call By Reference : 이름 + 인자(참조변수) 이용해서 호출
		*/

	public static void main(String[] args) {

		// 선 그리는 객체 생성

		MyLine ml = new MyLine();
		int line_len =36;
		

		System.out.printf("%18s\n","==[성적관리]==");
		//System.out.println("------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('=',line_len,3);
		System.out.println(" 번호 이름 국어 영어 수학 총점 평균");
		//System.out.println("------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('=',line_len,3);
		System.out.println(" 1  일길동  99   89   98  123   96");
		System.out.println(" 2  이길동  99   89   98  248   97");
		System.out.println(" 3  삼길동  99   89   98  296   98");
		//System.out.println("------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('*',5,'-',3,line_len);
		
	}
}

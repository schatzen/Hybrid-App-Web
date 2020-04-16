class Ex_Method2
{
	/*
       Method호출방식에 따른 분류
	   1.Call By Name(이름만 이용해서 호출)
	   2.Call By Value(이름+인자(Value) 이용해서 호출)
	   3.Call By Reference(이름+인자(참조변수) 이용해서 호출)
	*/
	public static void main(String[] args) 
	{
		//선그리는 객체 생성
		MyLine ml = new MyLine();
	    int line_len = 40;//선길이

		System.out.printf("%22s\n","===[성적관리]===");
		//System.out.println("----------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('=',line_len);

		System.out.println(" 번호  이름  국어 영어 수학  총점  평균");
		//System.out.println("----------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('=',line_len);
		System.out.println("  1   일길동  99   89   98   297    96");
		System.out.println("  2   이길동  99   89   98   289    97");
		System.out.println("  3   삼길동  99   89   98   296    98");
		//System.out.println("----------------------------------");
		//ml.draw_line();
		//ml.draw_line(line_len);
		ml.draw_line('*',2,'-',2,line_len);
		// *---*---*---*---*---*---*---*---*---*---*---*---
		// **--**--**--**--**--**--**--**--**--**--**--**--

		
	}
}

import java.util.Calendar;

class Ex_If_3
{
	public static void main(String[] args) 
	{
		int year=1980;
		int age;
		String tti="";


        //Design(설계) Pattern(Singleton)
		//: 과거개발방법중 최적화된 내용을 정리해놓는 
		//  개발방법론 
		
		//날짜관리:현재 시스템 날짜구함(년월일시분초밀리세크)
		Calendar c  = Calendar.getInstance();
        
		int current_year = c.get(Calendar.YEAR); 
		//월은 1월:0  2월:1
        int current_month= c.get(Calendar.MONTH) + 1;
		int current_day  = c.get(Calendar.DATE);
        

		System.out.printf("오늘은 %d년 %d월 %d일\n",
			              current_year,
			              current_month,
			              current_day);



		//나이 구하기
		//       올해      - 출생년도 + 1  
		age = current_year - year     + 1;

		//띠구하기
        //   출생년도%12 => 0~11 
		// 12지
		// 4  5  6  7  8  9  10 11 0  1  2  3  <= year%12
		// 자 축 인 묘 진 사 오 미 신 유 술 해
        // 쥐 소 범 토 용 뱀 말 양 원 닭 개 돼

        if(year%12==0) tti="원숭이";
		else if(year%12==1) tti="닭";
		else if(year%12==2) tti="개";
		else if(year%12==3) tti="돼지";
		else if(year%12==4) tti="쥐";
		else if(year%12==5) tti="소";
		else if(year%12==6) tti="호랑이";
		else if(year%12==7) tti="토끼";
		else if(year%12==8) tti="용";
		else if(year%12==9) tti="뱀";
		else if(year%12==10) tti="말";
		else if(year%12==11) tti="양";

        System.out.printf("출생년도:%d\n",year);
        System.out.printf("나이:%d(살)\n",age);
        System.out.printf("띠:%s(띠)\n",tti);






	}
}

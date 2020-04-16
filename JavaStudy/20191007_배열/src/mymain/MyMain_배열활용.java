package mymain;

public class MyMain_배열활용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//##활용1
		//  1  2  3  4  5  6  7  8  9  10 11 12 <= month
	    //  0  1  2  3  4  5  6  7  8  9  10 11 <= index(첨자)
		//  31 28 31 30 31 30 31 31 30 31 30 31
		
		int month = 12;
		//                     0  1  2  3 ...
		int [] month_array = {31,28,31,30,31,30,31,31,30,31,30,31};
		int last_day = month_array[month-1];
		
		/*
		switch(month) 
	    {
		  case  4: 
		  case  6: 
		  case  9: 
		  case 11: last_day=30;break;
		  case  2: last_day=28;break;
		  default: last_day= 31;
		}
		*/
		
		System.out.printf("[%d]월은 [%d]일까지...\n",month,last_day);
		
		//##활용2
		int year = 2020;
		String tti="";
		//띠구하기 : 출생년도%12=> 0~11
		
		// 4  5  6  7  8  9  10 11 0  1  2  3 
		// 자 축 인 묘 진 사 오 미 신 유 술 해
		// 쥐 소 범 토 용 뱀 말 양 원 닭 개 돼
		//                         0      1   2     3  
		String [] tti_array = {"원숭이","닭","개","돼지",
				//              4    5      6       7  
				               "쥐","소","호랑이","토끼",
                //              8    9   10   11      				               
				               "용","뱀","말","양"};
		tti = tti_array[ year%12 ];
		/*
		switch(year%12)
		{
		   case 0: tti="원숭이";break;
		   case 1: tti="닭";break;
		   case 2: tti="개";break;
		}
		*/
		
		System.out.printf("[%d]년생 [%s]띠\n",year,tti);
		//올해=>2019
		
		//##활용3 : 10간 12지
		
		// 10간 : 년도%10=> 0 ~ 9          
		// 4  5  6  7  8  9  0  1  2  3
		// 갑 을 병 정 무 기 경 신 임 계
		//                      0     1   2    3    4 
		String [] gan_array = {"경","신","임","계","갑",
				               "을","병","정","무","기"};
		
				// 12지 : 년도%12=> 0 ~ 11
		// 4  5  6  7  8  9  10 11 0  1  2  3  
		// 자 축 인 묘 진 사 오 미 신 유 술 해
		String [] ji_array = {"신","유","술","해",
							  "자","축","인","묘",
							  "진","사","오","미"};
		
		String ganji = gan_array[year%10] + ji_array[year%12];
		
		System.out.printf("[%d]년 [%s년]\n",year,ganji);
		
		
		
	}

}

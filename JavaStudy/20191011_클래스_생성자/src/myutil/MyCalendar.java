package myutil;

import java.util.Calendar;

public class MyCalendar {

	int year,month;
	int [][] cal_array;
	
	//매월의 마지막날을 저장할 배열
	//                    0  1  2 ...                 9 10 11  
	int [] month_array = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	//년월을 입력받는 메소드
	//인스턴스 메소드<= 객체가 생성되어야 생성되는 메소드
	public void setDate(int year,int month) {
		this.year = year;
		this.month= month;
		
		//달력만들기
		this.make_calendar();
	}
	
	//윤년여부?
	public boolean isYoon() {
		//                  조건1    이거나    조건2   
		boolean result =(year%400==0) || (year%4==0 && year%100!=0);
		
		return result;
	}
	
	
	
	private void make_calendar() {
		// TODO Auto-generated method stub
		cal_array = new int[6][7];
		
		
		int week = 0;
		int yoil = 0;
		
		//윤년여부?
		if(this.isYoon())
			month_array[1] = 29;
		else
			month_array[1] = 28;
		
		//요일구하기
		Calendar c = Calendar.getInstance();
		//날짜셋팅
		c.set(year,month-1,1);
		//요일구하기
		yoil = c.get(Calendar.DAY_OF_WEEK)-1;
		
		//System.out.println("요일:" + yoil);
		//이전달 달력채우기
		if(yoil!=0) {
			int prev_yoil = yoil-1;
			
			// 이전달 마지막 날짜를 구해야된다
			int prev_month = month-1;//이전달
			if(prev_month==0) {
				prev_month=12;
			}
			
			//이전달 마지막 날
			int prev_last_day = month_array[prev_month-1];
						
			for(int i=prev_yoil; i>=0;i--) {
				cal_array[week][i]=prev_last_day;
				prev_last_day--;
			}
		}
		
		//이번달 달력채우기
		for(int i=1;i<= month_array[month-1];i++) {
			cal_array[week][yoil]=i;
			yoil++;
			if(yoil>6) {
				week++;
				yoil=0;
			}
		}
		
		//다음달 달력채우기
		for(int i=1;i<20;i++) {
			cal_array[week][yoil]=i;
			yoil++;
			if(yoil>6) {
				week++;
				yoil=0;
				//배열 끝까지 채워졌으면 빠져나와라..
				if(week>5)break;
			}
		}
		
		
	}



	//달력출력
	public void display() {
		
		//요일출력
		String [] str_yoil = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		System.out.println("-----------------------------");
		for(int i=0;i<7;i++) {
			System.out.printf("%4s",str_yoil[i]);
		}
		System.out.println();
		System.out.println("-----------------------------");
		
		
		for(int i=0;i<6;i++) {
			for(int k=0;k<7;k++) {
				System.out.printf("%4d",cal_array[i][k]);
			}
			
			System.out.println();//줄바꾸기
		}
		
	}
	
	
}

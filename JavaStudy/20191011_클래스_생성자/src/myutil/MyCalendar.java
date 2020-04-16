package myutil;

import java.util.Calendar;

public class MyCalendar {

	int year,month;
	int [][] cal_array;
	
	//�ſ��� ���������� ������ �迭
	//                    0  1  2 ...                 9 10 11  
	int [] month_array = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	//����� �Է¹޴� �޼ҵ�
	//�ν��Ͻ� �޼ҵ�<= ��ü�� �����Ǿ�� �����Ǵ� �޼ҵ�
	public void setDate(int year,int month) {
		this.year = year;
		this.month= month;
		
		//�޷¸����
		this.make_calendar();
	}
	
	//���⿩��?
	public boolean isYoon() {
		//                  ����1    �̰ų�    ����2   
		boolean result =(year%400==0) || (year%4==0 && year%100!=0);
		
		return result;
	}
	
	
	
	private void make_calendar() {
		// TODO Auto-generated method stub
		cal_array = new int[6][7];
		
		
		int week = 0;
		int yoil = 0;
		
		//���⿩��?
		if(this.isYoon())
			month_array[1] = 29;
		else
			month_array[1] = 28;
		
		//���ϱ��ϱ�
		Calendar c = Calendar.getInstance();
		//��¥����
		c.set(year,month-1,1);
		//���ϱ��ϱ�
		yoil = c.get(Calendar.DAY_OF_WEEK)-1;
		
		//System.out.println("����:" + yoil);
		//������ �޷�ä���
		if(yoil!=0) {
			int prev_yoil = yoil-1;
			
			// ������ ������ ��¥�� ���ؾߵȴ�
			int prev_month = month-1;//������
			if(prev_month==0) {
				prev_month=12;
			}
			
			//������ ������ ��
			int prev_last_day = month_array[prev_month-1];
						
			for(int i=prev_yoil; i>=0;i--) {
				cal_array[week][i]=prev_last_day;
				prev_last_day--;
			}
		}
		
		//�̹��� �޷�ä���
		for(int i=1;i<= month_array[month-1];i++) {
			cal_array[week][yoil]=i;
			yoil++;
			if(yoil>6) {
				week++;
				yoil=0;
			}
		}
		
		//������ �޷�ä���
		for(int i=1;i<20;i++) {
			cal_array[week][yoil]=i;
			yoil++;
			if(yoil>6) {
				week++;
				yoil=0;
				//�迭 ������ ä�������� �������Ͷ�..
				if(week>5)break;
			}
		}
		
		
	}



	//�޷����
	public void display() {
		
		//�������
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
			
			System.out.println();//�ٹٲٱ�
		}
		
	}
	
	
}

import java.util.Scanner;

class 문제1
{
	public static void main(String[] args) 
	{
		/*
           1.점수입력받기(kor)
		   2.등급계산(if사용)
		         A0      A     A+
			 9   90~92  93~95  96~
			     B0      B     B+ 
			 8   80~82  83~85  86~ 
		*/
        Scanner scan = new Scanner(System.in);
		int kor;
		String grade="";
		System.out.print("국어:");
		kor = scan.nextInt();

		//등급계산
		if(kor>=96 && kor<=100) grade="A+";
		else if(kor>=93 && kor<=95) grade="A";
		else if(kor>=90 && kor<=92) grade="A0";
        else if(kor>=86 && kor<=89) grade="B+";
		else if(kor>=83 && kor<=85) grade="B";
		else if(kor>=80 && kor<=82) grade="B0";
		else if(kor>=76 && kor<=79) grade="C+";
		else if(kor>=73 && kor<=75) grade="C";
		else if(kor>=70 && kor<=72) grade="C0";
		else if(kor>=66 && kor<=69) grade="D+";
		else if(kor>=63 && kor<=65) grade="D";
		else if(kor>=60 && kor<=62) grade="D0";
		else grade="F";

		System.out.printf("[%d]점 등급:%s\n",kor,grade);
           





	}
}

package mymain;

public class mymain_String비교 {

	public static void main(String[] args) {

		// 묵시적 생성방법 ( 객체 생성 )
		String s1 = "Twinkle";
		String s2 = "Twinkle";

		// 명시적 생성방법
		String s3 = new String("Little Star");
		String s4 = new String("Little Star");

		System.out.println("Twinkle 비교");
		if (s1 == s2)
			System.out.println("---같다---");
		else
			System.out.println("---틀리다---");

		System.out.println("Little Star 비교");
		if (s3 == s4)
			System.out.println("---같다---");
		else
			System.out.println("---틀리다---");

		System.out.println();

		// ----------------------------------------------

		System.out.println("Twinkle 비교 (equals)");
		if (s1.equals(s2))
			System.out.println("---같다---");
		else
			System.out.println("---틀리다---");

		System.out.println("Little Star 비교 (equals)");
		if (s3.equals(s4))
			System.out.println("---같다---");
		else
			System.out.println("---틀리다---");

	}

}

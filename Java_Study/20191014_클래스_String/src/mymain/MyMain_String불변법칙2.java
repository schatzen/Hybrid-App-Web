package mymain;

public class MyMain_String불변법칙2 {

	public static void main(String[] args) {
		// 결론: 자바에서는 문자열 연산을 아래와 같이 하지 말 것
		// 이유: 메모리 낭비가 과다하게 발생

		int count = 0;
		String msg = ++count + " little." + 
					 ++count + " little." + 
					 ++count + " little Indian";
		System.out.println(msg);
		System.out.println(msg.length());
		
		//해결방법 1.StrungBuffer(기본적으로 16글자 저장)
		count = 0;
		StringBuffer sb = new StringBuffer();
		//StringBuffer sb = new StringBuffer(33); //>오버로드된 것

		sb.append(++count); //append는 계속 추가한다는 의미
		sb.append(" little.");
		sb.append(++count);
		sb.append(" little.");
		sb.append(++count);
		sb.append(" little Indian");
		
		//StringBuffer내의 값을 String으로 반환받는다.
		String msg1 = sb.toString();
		System.out.println(msg1);
		System.out.println(msg1.length());
		
		//해결방법 2. String.format("출력서식",값) : JDK1.5 이후부터 지원
		count = 0;
		String msg2 = String.format("%d little.%d little.%d little Indian", 
				++count,++count,++count); //static메소드
		
		System.out.println(msg2);
		System.out.println(msg2.length());
		
		
	}

}

package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice {
	
	@Autowired
	HttpServletRequest request;
	
	
	public void before(JoinPoint jp){
		Signature s =  jp.getSignature();
		long start = System.currentTimeMillis();
		request.setAttribute("start", start);
		
		System.out.println("----before:" + s);
	}
	
	public void after(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		long start = (Long)request.getAttribute("start");
		
		long end = System.currentTimeMillis();
		System.out.printf("[수행시간]:%d(ms)\n", (end-start));
		
		System.out.println("----after:" + s);
		//System.out.println("----after:" + s.toLongString());
	}
}

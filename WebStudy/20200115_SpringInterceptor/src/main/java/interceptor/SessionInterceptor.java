package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		HttpSession session = request.getSession();
		//admin or adult 경로로 요청이 되면 로그인여부 체크
		// /interceptor/admin/*.do   or  /interceptor/adult/*.do
		if(uri.contains("admin") || uri.contains("adult")) {
			
			Object user = session.getAttribute("user");
			if(user==null) {//로그인 안된경우
				
				response.sendRedirect("../member/login_form.do");
				
				return false;
			}
		}
		
		
		return super.preHandle(request, response, handler);
	}

	
	
}

package hpu.zyf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * ���õ�������
 * �����û���ǰ״̬����������
 * �û�Ϊ��¼״̬�£�ֻ�������Ʒ��Ϣ��û�й�����ӹ��ﳵȨ��
 * @author admin
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	      /*  String requestUri = request.getRequestURI();  
	        String contextPath = request.getContextPath();  
	        String url = requestUri.substring(contextPath.length());  
	        
	        System.out.println("requestUri:"+requestUri); 
	        System.out.println( "contextPath:"+contextPath);
	        System.out.println("url:"+url);*/
	          
	        String username =  (String)request.getSession().getAttribute("userName");   
	        if(username != null){  
	            return true;  
	        }  
//	        request.getRequestDispatcher("/jsp/user/userLogin.jsp").forward(request, response);
	        return false;     
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		 System.out.println("postHandler....");
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}

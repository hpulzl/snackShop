package hpu.zyf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 公用的拦截器
 * 根据用户当前状态来进行拦截
 * 用户为登录状态下：只能浏览商品信息，没有购买、添加购物车权限
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

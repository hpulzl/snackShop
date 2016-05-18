package hpu.zyf.interceptor;

import hpu.zyf.controller.AdminController;
import hpu.zyf.entity.Admin;

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
public class AdminCommonInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	        Admin admin =  (Admin) AdminController.getSession().getAttribute("admin");   
	        if(admin != null){  
	            return true;  
	        }  
	        request.getRequestDispatcher("/jsp/admin/adminLogin.jsp").forward(request, response);
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

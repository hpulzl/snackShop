package hpu.zyf.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �Զ����쳣�࣬���������쳣��Ϣ.ʵ��HandlerExceptionResolver�ӿ�
 * ���쳣��Ϣ��ǰ�˴�����ʱ����н�����
 * �����쳣ת����������档
 * @author admin
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex) {
		CustomException customException = null;
		AdminCustomException admincustomException = null;
		ModelAndView mv = new ModelAndView();
		//����ܽ�����������׳����ͣ��ͻ���ʾ����Ĵ�����Ϣ
		if(ex instanceof CustomException){
			customException = (CustomException) ex;
		}else if(ex instanceof AdminCustomException){ //����ǹ���Ա�����׳����쳣
			admincustomException = (AdminCustomException) ex;
			String message = admincustomException.getMessage();
			mv.addObject("message", message);
			mv.setViewName("adminError");
			return mv;
		}else{ //����Ļ��ͻ��׳�ϵͳδ֪����
			customException =new CustomException("ϵͳδ֪����");
		}
		String message = customException.getMessage();
		mv.addObject("message", message);
		mv.setViewName("error");
		return mv;
	}

}

package hpu.zyf.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常类，解析各种异常信息.实现HandlerExceptionResolver接口
 * 将异常信息在前端处理器时候进行解析，
 * 并将异常转发到错误界面。
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
		//如果能解析出具体的抛出类型，就会显示具体的错误信息
		if(ex instanceof CustomException){
			customException = (CustomException) ex;
		}else if(ex instanceof AdminCustomException){ //如果是管理员哪里抛出的异常
			admincustomException = (AdminCustomException) ex;
			String message = admincustomException.getMessage();
			mv.addObject("message", message);
			mv.setViewName("adminError");
			return mv;
		}else{ //否则的话就会抛出系统未知错误
			customException =new CustomException("系统未知错误");
		}
		String message = customException.getMessage();
		mv.addObject("message", message);
		mv.setViewName("error");
		return mv;
	}

}

package hpu.zyf.exception;
/**
 * 异常类，继承Exception类
 * 设置异常信息
 * @author admin
 *
 */
public class AdminCustomException extends Exception{
	//异常信息
	public String message;
	
	public AdminCustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

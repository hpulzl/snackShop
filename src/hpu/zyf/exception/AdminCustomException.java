package hpu.zyf.exception;
/**
 * �쳣�࣬�̳�Exception��
 * �����쳣��Ϣ
 * @author admin
 *
 */
public class AdminCustomException extends Exception{
	//�쳣��Ϣ
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

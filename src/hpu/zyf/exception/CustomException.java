package hpu.zyf.exception;
/**
 * �쳣�࣬�̳�Exception��
 * �����쳣��Ϣ
 * @author admin
 *
 */
public class CustomException extends Exception{
	//�쳣��Ϣ
	public String message;
	
	public CustomException(String message) {
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

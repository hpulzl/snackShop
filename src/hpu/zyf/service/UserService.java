package hpu.zyf.service;

import hpu.zyf.entity.User;

/**
 * �û���service�ӿڡ�
 * �����û���¼��ע�ᡣ
 * @author admin
 */
public interface UserService {
	User userLogin(String username,String password)throws Exception;
	boolean userRegister(User user)throws Exception;
	boolean updateUser(User user)throws Exception;
}

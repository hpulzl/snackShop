package hpu.zyf.service;

import hpu.zyf.entity.User;

/**
 * 用户的service接口。
 * 包括用户登录、注册。
 * @author admin
 */
public interface UserService {
	User userLogin(String username,String password)throws Exception;
	boolean userRegister(User user)throws Exception;
	boolean updateUser(User user)throws Exception;
}

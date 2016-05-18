package hpu.zyf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import hpu.zyf.entity.User;
import hpu.zyf.exception.CustomException;
import hpu.zyf.mapper.UserMapper;
import hpu.zyf.service.UserService;
/**
 * 用户接口的实现类，
 * 实现登录、注册功能。
 * 修改用户信息
 * @author admin
 *
 */
public class UserServiceImpl implements UserService{
	@Autowired 
	public UserMapper um;
	@Override
	public User userLogin(String username, String password) throws Exception {
		User u = um.selectByPhone(username);
		if(u != null && u.getUserpassword().equals(password)){
			return u;
		}
		return null;
	}

	@Override
	public boolean userRegister(User user) throws Exception {
		user.setUserid(hpu.zyf.util.UUIDUtil.getUUId());
		if(um.insert(user)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		if(um.updateByPrimaryKeySelective(user)>0){
			return true;
		}
		return false;
	}

}

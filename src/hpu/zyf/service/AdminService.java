package hpu.zyf.service;

import hpu.zyf.entity.Admin;

/**
 * 管理员的服务接口类
 * 包括管理员的登录、注册,修改密码。
 * @author admin
 *
 */
public interface AdminService {
	Admin adminLogin(String adminphone,String adminPassword)throws Exception;
	boolean adminRegister(Admin admin)throws Exception;
	boolean updateAdmin(Admin admin)throws Exception;
}

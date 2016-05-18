package hpu.zyf.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import hpu.zyf.entity.Admin;
import hpu.zyf.exception.AdminCustomException;
import hpu.zyf.exception.CustomException;
import hpu.zyf.mapper.AdminMapper;
import hpu.zyf.service.AdminService;
import hpu.zyf.util.UUIDUtil;
/**
 * 管理员接口实现类
 * @author admin
 *
 */
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper am;
	@Override
	public Admin adminLogin(String adminphone, String adminPassword)
			throws Exception {
		Admin admin = am.selectByAdminname(adminphone);
		if(admin !=null){
			return admin;
		}
		return null;
	}

	@Override
	public boolean adminRegister(Admin admin) throws Exception {
		if(admin==null){
			throw new AdminCustomException("管理员对象不存在");
		}
		admin.setAdminid(UUIDUtil.getUUId());
		if(am.insert(admin)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAdmin(Admin admin) throws Exception {
		if(admin==null){
			throw new AdminCustomException("要更新的对象不存在");
		}
		if(am.updateByPrimaryKey(admin)>0){
			return true;
		}
		return false;
	}

}

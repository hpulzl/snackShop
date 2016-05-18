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
 * ����Ա�ӿ�ʵ����
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
			throw new AdminCustomException("����Ա���󲻴���");
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
			throw new AdminCustomException("Ҫ���µĶ��󲻴���");
		}
		if(am.updateByPrimaryKey(admin)>0){
			return true;
		}
		return false;
	}

}

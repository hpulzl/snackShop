package hpu.zyf.service;

import hpu.zyf.entity.Admin;

/**
 * ����Ա�ķ���ӿ���
 * ��������Ա�ĵ�¼��ע��,�޸����롣
 * @author admin
 *
 */
public interface AdminService {
	Admin adminLogin(String adminphone,String adminPassword)throws Exception;
	boolean adminRegister(Admin admin)throws Exception;
	boolean updateAdmin(Admin admin)throws Exception;
}

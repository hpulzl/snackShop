package hpu.zyf.service;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.User;
import hpu.zyf.entity.vo.UserCustom;

import java.util.List;

/**
 * ��ӹ��ﳵ�ṩ�Ľӿ�
 * ��������������Ʒ���û���
 * @author admin
 */
public interface AddShopCartService {
	//���������Ʒ�����ﳵ
	boolean addShopCart(String userid,String pdid,Orderdetail detail)throws Exception;
	//ͨ���û�idɾ��������Ϣ
	boolean deleteShopCartByUserid(String userid,String odid,String orderid)throws Exception;
	//ͨ������idɾ��������Ϣ
	boolean deleteShopCartByOrderid(String orderid,String odid)throws Exception;
	//��ѯ������ͨ���û�id��ѯ���û������ж���
	UserCustom selectByUserid(String userid)throws Exception;
	//������Ʒ
	boolean payByUser(String orderId)throws Exception;
}

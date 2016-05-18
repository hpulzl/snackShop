package hpu.zyf.entity.vo;

import java.io.Serializable;
import java.util.List;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.User;
import hpu.zyf.entity.Userorder;

/**
 * ������ѯ�û���������Ϣ
 * @author admin
 */
public class UserCustom extends User implements Serializable{
	//һ���û��ж�Ӧ�������
	private List<UserOrderCustom> userOrderList;

	public List<UserOrderCustom> getUserOrderList() {
		return userOrderList;
	}

	public void setUserOrderList(List<UserOrderCustom> userOrderList) {
		this.userOrderList = userOrderList;
	}
}

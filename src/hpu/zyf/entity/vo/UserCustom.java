package hpu.zyf.entity.vo;

import java.io.Serializable;
import java.util.List;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.User;
import hpu.zyf.entity.Userorder;

/**
 * 级联查询用户订单的信息
 * @author admin
 */
public class UserCustom extends User implements Serializable{
	//一个用户有对应多个订单
	private List<UserOrderCustom> userOrderList;

	public List<UserOrderCustom> getUserOrderList() {
		return userOrderList;
	}

	public void setUserOrderList(List<UserOrderCustom> userOrderList) {
		this.userOrderList = userOrderList;
	}
}

package hpu.zyf.entity.vo;

import java.util.List;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.Userorder;

/**
 * ���������չ��
 * @author admin
 *
 */
public class UserOrderCustom extends Userorder{
	private OrderdetailCustom orderdetails;

	public OrderdetailCustom getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(OrderdetailCustom orderdetails) {
		this.orderdetails = orderdetails;
	}
}

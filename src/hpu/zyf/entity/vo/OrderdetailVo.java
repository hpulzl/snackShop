package hpu.zyf.entity.vo;

import hpu.zyf.entity.Discountproduct;
import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.User;
import hpu.zyf.entity.Userorder;

/**
 * ����ͨ��entity��İ�װ��
 * �ṩ��Ʒ�����������չ��
 * �����û�����Ϣ����Ʒ����Ϣ�Ͷ�����Ϣ
 * @author admin
 *
 */
public class OrderdetailVo {
	private Discountproduct disProduct;
	private Productdetail proDetail;
	private Orderdetail orderDetail;
	private Userorder userOrder;
	private User user;
	
	public Userorder getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(Userorder userOrder) {
		this.userOrder = userOrder;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Productdetail getProDetail() {
		return proDetail;
	}
	public void setProDetail(Productdetail proDetail) {
		this.proDetail = proDetail;
	}
	public Discountproduct getDisProduct() {
		return disProduct;
	}
	public void setDisProduct(Discountproduct disProduct) {
		this.disProduct = disProduct;
	}
	public Orderdetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(Orderdetail orderDetail) {
		this.orderDetail = orderDetail;
	}
}

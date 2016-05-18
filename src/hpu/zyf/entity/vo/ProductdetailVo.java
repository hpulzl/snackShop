package hpu.zyf.entity.vo;

import hpu.zyf.entity.Discountproduct;
import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.Productdetail;

/**
 * 对普通的entity类的包装，
 * 提供代码的扩展性
 * @author admin
 *
 */
public class ProductdetailVo {
	private Discountproduct disProduct;
	private Productdetail proDetail;
	private Orderdetail orderDetail;
	
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

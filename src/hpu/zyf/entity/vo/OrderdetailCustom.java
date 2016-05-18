package hpu.zyf.entity.vo;

import hpu.zyf.entity.Orderdetail;

/**
 * 订单明细的扩展类
 * @author admin
 *
 */
public class OrderdetailCustom extends Orderdetail{
	private ProductCustom productCustom;

	public ProductCustom getProductCustom() {
		return productCustom;
	}

	public void setProductCustom(ProductCustom productCustom) {
		this.productCustom = productCustom;
	}
}

package hpu.zyf.entity.vo;

import hpu.zyf.entity.Orderdetail;

/**
 * ������ϸ����չ��
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

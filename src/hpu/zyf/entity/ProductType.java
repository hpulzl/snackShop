package hpu.zyf.entity;
/**
 * 商品类型表
 * 包括商品类型的id和商品类型的name
 * @author admin
 *
 */
public class ProductType {
	private String ptid;
	private String pttype;
	
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getPttype() {
		return pttype;
	}
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	
	
}

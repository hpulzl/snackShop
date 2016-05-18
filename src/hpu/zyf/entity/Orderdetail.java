package hpu.zyf.entity;
/**
 * ¶©µ¥Ã÷Ï¸ÏêÇé
 * @author admin
 *
 */
public class Orderdetail {
    private String odid;

    private String orderid;

    private Integer odnumber;

    private Float odprice;
    
    private String pdid;
    
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getOdid() {
        return odid;
    }

    public void setOdid(String odid) {
        this.odid = odid == null ? null : odid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getOdnumber() {
        return odnumber;
    }

    public void setOdnumber(Integer odnumber) {
        this.odnumber = odnumber;
    }

    public Float getOdprice() {
        return odprice;
    }

    public void setOdprice(Float odprice) {
        this.odprice = odprice;
    }
}
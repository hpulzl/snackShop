package hpu.zyf.entity;

import java.util.Date;
/**
 * ¶©µ¥ÏêÇé
 * @author admin
 *
 */
public class Userorder {
    private String orderid;

    private String userid;
    
    private String purchaseid;

    private Date ordertime;

    private Boolean ispay;
    
    public Userorder(){
    	
    }
    
    public Userorder(String orderid, String userid, String purchaseid,
			Date ordertime, Boolean ispay) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.purchaseid = purchaseid;
		this.ordertime = ordertime;
		this.ispay = ispay;
	}

	public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(String purchaseid) {
        this.purchaseid = purchaseid == null ? null : purchaseid.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Boolean getIspay() {
        return ispay;
    }

    public void setIspay(Boolean ispay) {
        this.ispay = ispay;
    }
}
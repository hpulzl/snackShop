package hpu.zyf.entity;
/**
 * ¹ºÂò²úÆ·ÏêÇé
 * @author admin
 *
 */
public class Purchase {
    private String purchaseid;

    private String orderid;

    private String purchasetime;

    public String getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(String purchaseid) {
        this.purchaseid = purchaseid == null ? null : purchaseid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getPurchasetime() {
        return purchasetime;
    }

    public void setPurchasetime(String purchasetime) {
        this.purchasetime = purchasetime == null ? null : purchasetime.trim();
    }
}
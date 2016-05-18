package hpu.zyf.entity;

import java.util.Date;
/**
 * 商品明细详情
 * @author admin
 *
 */
public class Productdetail {
    private String pdid;  //商品id

    private String odid;  //订单id

    private String disid; //打折id

    private String commentid;  //评论id

    private String pdtype;

    private String pdname;

    private Float pdprice;

    private Float disprice;

    private Date createtime;

    private String pdimage;

    private String pddetail;

    public String getPdid() {
        return pdid;
    }

    public void setPdid(String pdid) {
        this.pdid = pdid == null ? null : pdid.trim();
    }

    public String getOdid() {
        return odid;
    }

    public void setOdid(String odid) {
        this.odid = odid == null ? null : odid.trim();
    }

    public String getDisid() {
        return disid;
    }

    public void setDisid(String disid) {
        this.disid = disid == null ? null : disid.trim();
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    public String getPdtype() {
        return pdtype;
    }

    public void setPdtype(String pdtype) {
        this.pdtype = pdtype == null ? null : pdtype.trim();
    }

    public String getPdname() {
        return pdname;
    }

    public void setPdname(String pdname) {
        this.pdname = pdname == null ? null : pdname.trim();
    }

    public Float getPdprice() {
        return pdprice;
    }

    public void setPdprice(Float pdprice) {
        this.pdprice = pdprice;
    }

    public Float getDisprice() {
        return disprice;
    }

    public void setDisprice(Float disprice) {
        this.disprice = disprice;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPdimage() {
        return pdimage;
    }

    public void setPdimage(String pdimage) {
        this.pdimage = pdimage == null ? null : pdimage.trim();
    }

    public String getPddetail() {
        return pddetail;
    }

    public void setPddetail(String pddetail) {
        this.pddetail = pddetail == null ? null : pddetail.trim();
    }
}
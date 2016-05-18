package hpu.zyf.entity;

import java.util.Date;
/**
 * 打折商品详情
 * @author admin
 *
 */
public class Discountproduct {
    private String disid;

    private String pdid;

    private Date starttime;

    private Date endtime;

    public String getDisid() {
        return disid;
    }

    public void setDisid(String disid) {
        this.disid = disid == null ? null : disid.trim();
    }

    public String getPdid() {
        return pdid;
    }

    public void setPdid(String pdid) {
        this.pdid = pdid == null ? null : pdid.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
package hpu.zyf.entity.vo;

import java.util.Date;

import hpu.zyf.entity.Discountproduct;
import hpu.zyf.entity.Productdetail;

/**
 * 包括其他属性
 * @author admin
 *
 */
public class ProductCustom extends Productdetail{
	
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

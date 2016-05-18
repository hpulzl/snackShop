package hpu.zyf.entity;

import java.util.Date;
/**
 * ∆¿¬€œÍ«È
 * @author admin
 *
 */
public class Comment {
    private String commentid;

    private String userid;

    private Float commentscore;

    private Date conmmenttime;

    private String content;
    
    private String pdid;
    
    public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Float getCommentscore() {
        return commentscore;
    }

    public void setCommentscore(Float commentscore) {
        this.commentscore = commentscore;
    }

    public Date getConmmenttime() {
        return conmmenttime;
    }

    public void setConmmenttime(Date conmmenttime) {
        this.conmmenttime = conmmenttime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
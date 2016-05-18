package hpu.zyf.entity.vo;

import hpu.zyf.entity.Comment;
/**
 * 评论表的扩展类,包括用户的所有信息
 * @author admin
 */
public class CommentCustom extends Comment{
	 private String userid;

	    private String username;

	    private String userpassword;

	    private String userphone;

	    public String getUserid() {
	        return userid;
	    }

	    public void setUserid(String userid) {
	        this.userid = userid == null ? null : userid.trim();
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username == null ? null : username.trim();
	    }

	    public String getUserpassword() {
	        return userpassword;
	    }

	    public void setUserpassword(String userpassword) {
	        this.userpassword = userpassword == null ? null : userpassword.trim();
	    }

	    public String getUserphone() {
	        return userphone;
	    }

	    public void setUserphone(String userphone) {
	        this.userphone = userphone == null ? null : userphone.trim();
	    }
}

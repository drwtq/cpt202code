package javaBean;

import java.io.Serializable;
import java.sql.Date;

public class Detail implements Serializable{
	private String cid;
	private String mid;
	private String cuser;
	private String comment;
	private Date ctime;
	
	
	public Detail() {
		cid ="";
		cuser="";
		comment = "";
	}
	
	public Detail(String cuser, String mid, String comment,Date ctime) {
		this.cuser=cuser;
		this.mid= mid;
		this.comment =comment;
		this.ctime = ctime;		
	}
	
	
	public String getcid() {
		return cid;
	}
	
	public String getmid() {
		return mid;
	}
	public String getcomment() {
		return comment;
	}
	
	public String getcuser() {
		return cuser;
	}
	
	public Date getctime() {
		return ctime;
	}
	
	
	
	public void setcid(String cid) {
		this.cid = cid;
	}
	
	public void setmid(String mid) {
		this.mid = mid;
	}
	
	public void setcomment(String comment) {
		this.comment = comment;
	}

	public void setcuser(String cuser) {
		this.cuser = cuser;
	}

	public void setctime(Date ctime) {
		this.ctime = ctime;
	}
}

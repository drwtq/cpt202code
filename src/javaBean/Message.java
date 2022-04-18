package javaBean;

import java.io.Serializable;

public class Message implements Serializable{
	/**
	 * 
	 */
	private String mid;
	private String userid;
	private String title;
	private String context;
	
	
	public Message() {
		mid ="";
		userid="";
		title = "";
		context = "";
	}
	
	public Message(String userid,String title,String context) {
		this.userid=userid;
		this.title =title;
		this.context = context;		
	}
	
	
	public String getmid() {
		return mid;
	}
	
	public String gettitle() {
		return title;
	}
	
	public String getuserid() {
		return userid;
	}
	
	public String getcontext() {
		return context;
	}
	
	
	
	public void setuserid(String userid) {
		this.userid = userid;
	}
	
	public void settitle(String title) {
		this.title = title;
	}

	public void setmid(String mid) {
		this.mid = mid;
	}

	public void setcontext(String context) {
		this.context = context;
	}
}

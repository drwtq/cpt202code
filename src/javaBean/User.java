package javaBean;

import java.io.*;

public class User implements Serializable{
	private String id;
	private String username;
	private String password;
	
	
	public User() {
		id ="";
		username = "";
		password = "";
	}
	
	public User(String username,String password) {
		this.username =username;
		this.password = password;		
	}
	
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	
	public String getusername() {
		return username;
	}
	
	public void setusername(String username) {
		this.username = username;
	}

	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}

}


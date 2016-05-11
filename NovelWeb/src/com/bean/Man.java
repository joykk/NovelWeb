package com.bean;

public class Man {

	private String userName;
	private String pwd;
	public Man() {
	}
	public Man(String userName) {
		this.userName=userName;
	}
	
	public Man(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

package com.bean;

import java.sql.Date;

public class AuthorBean extends Man{
	private int authorID;
	private String authorName;
	private String userName;
	private String pwd;
	private String sex;
	private Date birthday;
	private String status;//enable|ͣdisable״̬
	private String lastLoginTime;//上次登录时间
	
	public AuthorBean() {
	}
	public AuthorBean(Man user) {
		super();
		this.userName = user.getUserName();
		this.pwd = user.getPwd();
	}
	public AuthorBean(String userName, String password) {
		this.userName = userName;
		this.pwd = password;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	
}

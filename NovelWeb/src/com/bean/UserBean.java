package com.bean;

import java.sql.Date;

public class UserBean extends Man{

	private int id;
	private String readerName;
	private String userName;
	private String nickName;
	private String pwd;
	private String sex;
	private Date birthday;
	private String status;//enable|disabled	״̬
	private String lastLoginTime;//
	
	public UserBean(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}

	public UserBean(String userName) {
		super();
		this.userName = userName;
	}
	public UserBean(Man user) {
		super();
		this.userName = user.getUserName();
		this.pwd = user.getPwd();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

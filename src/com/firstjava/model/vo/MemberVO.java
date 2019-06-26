package com.firstjava.model.vo;

public class MemberVO {
	private String userId;
	private String password;
	private String uname;
	private String email;
	private String phone;
	
	public MemberVO() {
	
	}
	
	
	public MemberVO(String userId, String password, String uname, String email, String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.uname = uname;
		this.email = email;
		this.phone = phone;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


}

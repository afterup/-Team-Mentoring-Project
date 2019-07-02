package com.firstjava.model.vo;

public class RegisterVO {
	private int classno;
	private String cname; //강의 이름
	private String mentor;
	private int rate;
	
	
	
	
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public RegisterVO(int classno, String cname, String mentor, int rate) {
		super();
		this.classno = classno;
		this.cname = cname;
		this.mentor = mentor;
		this.rate = rate;
	}
	public RegisterVO() {
		super();
	}
	
	
	
	
}
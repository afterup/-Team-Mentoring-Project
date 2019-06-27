package com.firstjava.model.vo;

public class ClassVO {
	private String cname;
	private String openDate;
	private String closeDate;
	private int student; // 현재 수강 인원수
	private int quorum; // 강의 정원 수
	private int cateno; // 카테고리 번호
	
	
	//생성자
	public ClassVO(String cname, String openDate, String closeDate, int student, int quorum, int cateno) {
		super();
		this.cname = cname;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.student = student;
		this.quorum = quorum;
		this.cateno = cateno;
	}
	
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
	}
	public int getQuorum() {
		return quorum;
	}
	public void setQuorum(int quorum) {
		this.quorum = quorum;
	}
	public int getCateno() {
		return cateno;
	}
	public void setCateno(int cateno) {
		this.cateno = cateno;
	}
	

}

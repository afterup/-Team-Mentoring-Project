package com.firstjava.model.vo;


public class ClassVO {
	private int classno;// 클래스번호
	private String userid; // 멘토 ID
	private String classinfo; //강의설명
	private int cateno; // 카테고리 번호
	private String cname; //카테고리 이름
	private String openDate; // 개강일
	private String closeDate; // 종강일
	private int student; // 현재 수강 인원수
	private int limit; // 강의 정원 수

	public ClassVO() {

	}

	public ClassVO(int classno, String userid, String classinfo, int cateno, String cname, String openDate,
			String closeDate, int student, int limit) {
		super();
		this.classno = classno;
		this.userid = userid;
		this.classinfo = classinfo;
		this.cateno = cateno;
		this.cname = cname;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.student = student;
		this.limit = limit;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getClassinfo() {
		return classinfo;
	}

	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}

	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
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

	public void setOpenDate(String date) {
		this.openDate = date;
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "ClassVO [classno=" + classno + ", userid=" + userid + ", classinfo=" + classinfo + ", cateno=" + cateno
				+ ", cname=" + cname + ", openDate=" + openDate + ", closeDate=" + closeDate + ", student=" + student
				+ ", limit=" + limit + "]";
	}

}

package com.firstjava.model.vo;

public class MentorVO
{
	
	private String userid;
	private String academy;
	private String major;
	private String certification;
	private String plan;
	
	public MentorVO()
	{
	}
	
	public MentorVO(String userid,String academy, String major, String certification, String plan)
	{
		super();
		this.userid = userid;
		this.academy = academy;
		this.major = major;
		this.certification = certification;
		this.plan = plan;
	}
	
	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	public String getAcademy()
	{
		return academy;
	}
	public void setAcademy(String academy)
	{
		this.academy = academy;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String major)
	{
		this.major = major;
	}
	public String getCertification()
	{
		return certification;
	}
	public void setCertification(String certification)
	{
		this.certification = certification;
	}
	public String getPlan()
	{
		return plan;
	}
	public void setPlan(String plan)
	{
		this.plan = plan;
	}

	
	
}

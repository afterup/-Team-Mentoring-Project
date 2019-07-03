package com.firstjava.model.vo;

public class MentorVO
{
	
	private String userid;
	private String job;
	private String major;
	private String license;
	private String plan;
	private String confirm;
	


	public MentorVO()
	{
	}
	
	public MentorVO(String userid,String job, String major, String license, String plan,String confirm)
	{
		super();
		this.userid = userid;
		this.job = job;
		this.major = major;
		this.license = license;
		this.plan = plan;
		this.confirm = confirm;
	}
	
	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	public String getJob()
	{
		return job;
	}
	public void setJob(String job)
	{
		this.job = job;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String major)
	{
		this.major = major;
	}
	public String getLicense()
	{
		return license;
	}

	public void setLicense(String license)
	{
		this.license = license;
	}

	public String getPlan()
	{
		return plan;
	}
	public void setPlan(String plan)
	{
		this.plan = plan;
	}
	public String getConfirm()
	{
		return confirm;
	}

	public void setConfirm(String confirm)
	{
		this.confirm = confirm;
	}

	
	
}

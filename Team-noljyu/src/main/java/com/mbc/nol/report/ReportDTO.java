package com.mbc.nol.report;

public class ReportDTO {
	int postreportnum,postnum;
	String postid,reportreason,reportid,reportdetail;
	public ReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getPostreportnum() {
		return postreportnum;
	}


	public void setPostreportnum(int postreportnum) {
		this.postreportnum = postreportnum;
	}


	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getReportreason() {
		return reportreason;
	}
	public void setReportreason(String reportreason) {
		this.reportreason = reportreason;
	}
	public String getReportid() {
		return reportid;
	}
	public void setReportid(String reportid) {
		this.reportid = reportid;
	}
	public String getReportdetail() {
		return reportdetail;
	}
	public void setReportdetail(String reportdetail) {
		this.reportdetail = reportdetail;
	}
	
	
}

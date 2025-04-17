package com.mbc.nol.report;

public class ReportDTO {
	int postreportnum,postnum;
	int reviewreportnum,postreviewnum;
	String postid,reportreason,reportid,reportdetail,reviewid;
	public ReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getReviewid() {
		return reviewid;
	}


	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}


	public int getPostreportnum() {
		return postreportnum;
	}


	public void setPostreportnum(int postreportnum) {
		this.postreportnum = postreportnum;
	}


	public int getReviewreportnum() {
		return reviewreportnum;
	}


	public void setReviewreportnum(int reviewreportnum) {
		this.reviewreportnum = reviewreportnum;
	}




	public int getPostreviewnum() {
		return postreviewnum;
	}


	public void setPostreviewnum(int postreviewnum) {
		this.postreviewnum = postreviewnum;
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

package com.mbc.nol.flea;

import java.sql.Date;

public class FleaDTO {
	int postnum;
	String id, posttitle, postdetail, postimg;
	int postcnt;
	String postdate, posttype;
	public FleaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getPostdetail() {
		return postdetail;
	}
	public void setPostdetail(String postdetail) {
		this.postdetail = postdetail;
	}
	public String getPostimg() {
		return postimg;
	}
	public void setPostimg(String postimg) {
		this.postimg = postimg;
	}
	public int getPostcnt() {
		return postcnt;
	}
	public void setPostcnt(int postcnt) {
		this.postcnt = postcnt;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public String getPosttype() {
		return posttype;
	}
	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}

	
	
}

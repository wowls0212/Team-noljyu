package com.mbc.nol.flea;

import java.sql.Date;

public class FleaDTO {
	int fleawnum;
	String id,fleatitle,fleadetail,fleaimg;
	int fleacnt;
	Date fleadate;
	public FleaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFleawnum() {
		return fleawnum;
	}
	public void setFleawnum(int fleawnum) {
		this.fleawnum = fleawnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFleatitle() {
		return fleatitle;
	}
	public void setFleatitle(String fleatitle) {
		this.fleatitle = fleatitle;
	}
	public String getFleadetail() {
		return fleadetail;
	}
	public void setFleadetail(String fleadetail) {
		this.fleadetail = fleadetail;
	}
	public String getFleaimg() {
		return fleaimg;
	}
	public void setFleaimg(String fleaimg) {
		this.fleaimg = fleaimg;
	}
	public int getFleacnt() {
		return fleacnt;
	}
	public void setFleacnt(int fleacnt) {
		this.fleacnt = fleacnt;
	}
	public Date getFleadate() {
		return fleadate;
	}
	public void setFleadate(Date fleadate) {
		this.fleadate = fleadate;
	}
	
	
}

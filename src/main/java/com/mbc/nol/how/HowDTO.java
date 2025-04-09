package com.mbc.nol.how;

import java.sql.Date;

public class HowDTO {
	int hownum;
	String id,howtitle,howdetail,howimg;
	int howcnt;
	Date howdate;
	public HowDTO() {}
	public HowDTO(int hownum, String id, String howtitle, String howdetail, String howimg, int howcnt, Date howdate) {
		super();
		this.hownum = hownum;
		this.id = id;
		this.howtitle = howtitle;
		this.howdetail = howdetail;
		this.howimg = howimg;
		this.howcnt = howcnt;
		this.howdate = howdate;
	}
	public int getHownum() {
		return hownum;
	}
	public void setHownum(int hownum) {
		this.hownum = hownum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHowtitle() {
		return howtitle;
	}
	public void setHowtitle(String howtitle) {
		this.howtitle = howtitle;
	}
	public String getHowdetail() {
		return howdetail;
	}
	public void setHowdetail(String howdetail) {
		this.howdetail = howdetail;
	}
	public String getHowimg() {
		return howimg;
	}
	public void setHowimg(String howimg) {
		this.howimg = howimg;
	}
	public int getHowcnt() {
		return howcnt;
	}
	public void setHowcnt(int howcnt) {
		this.howcnt = howcnt;
	}
	public Date getHowdate() {
		return howdate;
	}
	public void setHowdate(Date howdate) {
		this.howdate = howdate;
	}
	
	
}

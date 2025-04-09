package com.mbc.nol.how;

public class HowReviewDTO {
	int hownum;
	String id, review;
	int reviewnum, groups, step, indent;
	public HowReviewDTO() {}
	public HowReviewDTO(int hownum, String id, String review, int reviewnum, int groups, int step, int indent) {
		super();
		this.hownum = hownum;
		this.id = id;
		this.review = review;
		this.reviewnum = reviewnum;
		this.groups = groups;
		this.step = step;
		this.indent = indent;
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
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getReviewnum() {
		return reviewnum;
	}
	public void setReviewnum(int reviewnum) {
		this.reviewnum = reviewnum;
	}
	public int getGroups() {
		return groups;
	}
	public void setGroups(int groups) {
		this.groups = groups;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	
	
}

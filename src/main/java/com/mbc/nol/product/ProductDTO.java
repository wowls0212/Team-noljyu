package com.mbc.nol.product;

import java.sql.Date;

public class ProductDTO {
	int productnum;
	String id;
	String animal;
	String productlist;
	int price;
	String productimg;
	String productcnt;
    Date productdate;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductnum() {
		return productnum;
	}
	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getProductlist() {
		return productlist;
	}
	public void setProductlist(String productlist) {
		this.productlist = productlist;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductimg() {
		return productimg;
	}
	public void setProductimg(String productimg) {
		this.productimg = productimg;
	}
	public String getProductcnt() {
		return productcnt;
	}
	public void setProductcnt(String productcnt) {
		this.productcnt = productcnt;
	}
	public Date getProductdate() {
		return productdate;
	}
	public void setProductdate(Date productdate) {
		this.productdate = productdate;
	}
    
}

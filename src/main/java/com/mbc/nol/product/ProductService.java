package com.mbc.nol.product;

import java.util.ArrayList;

public interface ProductService {

	void productinput(String id, String animal, String productlist, int price, String fname, String productdate);

	ArrayList<ProductDTO> productout();

	void productcnt(int num);

	ProductDTO productdetail(int num);

	ProductDTO pmodify1(int unum);

	void pmodify2(int productnum, String id, String animal, String productlist, int price, String fname);

	ProductDTO pdelete1(int dnum);

	void pdelete2(int dnum);

}

package com.mbc.nol.product;

import java.util.ArrayList;

public interface ProductService {

	void productinput(String id, String animal, String productlist, int price, String fname, String productdate, String productname);

	ArrayList<ProductDTO> productout();

	void productcnt(int num);

	ProductDTO productdetail(int num);

	ProductDTO pmodify1(int unum);

	void pmodify2(int productnum, String id, String animal, String productlist, int price, String fname, String productdate, String productname);

	ProductDTO pdelete1(int dnum);

	void pdelete2(int dnum);

	ArrayList<ProductDTO> psearch2(String name, String value);

<<<<<<< HEAD
	ProductDTO dogproduct(int num);
=======
	ArrayList<ProductDTO> dogproductout();

	ArrayList<ProductDTO> catproductout();

	ArrayList<ProductDTO> birdproductout();

	ArrayList<ProductDTO> fishproductout();

	ArrayList<ProductDTO> creepproductout();

	ArrayList<ProductDTO> dogtoyliving();

	
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86

}

package com.mbc.nol.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ProductController {
	@Autowired
	SqlSession sqlSession;
	String path="C:\\MBC12AI\\NOLJYU-main\\src\\main\\webapp\\image";
	
	@RequestMapping(value = "/productinput")
	public String product1()
	{
		return "productinput";
	}
	
	@RequestMapping(value = "/productsave")
	public String product2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException
	{
			String id=mul.getParameter("id");
			String animal=mul.getParameter("animal");
			String productlist=mul.getParameter("productlist");
			int price=Integer.parseInt(mul.getParameter("price"));
			MultipartFile mf=mul.getFile("productimg");
			String fname=mf.getOriginalFilename();
			UUID uu=UUID.randomUUID();
			fname=uu.toString()+"_"+fname;
			mf.transferTo(new File(path+"\\"+fname));			
			String productdate=mul.getParameter("productdate");
			ProductService ps=sqlSession.getMapper(ProductService.class);
			ps.productinput(id,animal,productlist,price,fname,productdate);
			
			return "redirect:/main";
	}
	
	@RequestMapping(value = "/productout")
	public String product3(Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ArrayList<ProductDTO>list=ps.productout();
		model.addAttribute("list",list);
		
		return "productout";
	}
	
	@RequestMapping(value = "/productdetail")
	public String product4(HttpServletRequest request,Model model) 
	{
		int num=Integer.parseInt(request.getParameter("num"));
		ProductService ps=sqlSession.getMapper(ProductService.class);		
		ps.productcnt(num);
		ProductDTO dto=ps.productdetail(num);
		model.addAttribute("dto",dto);
		
		return "productdetail";
	}
	
	@RequestMapping(value = "/pmodify1")
	public String product5(HttpServletRequest request, Model model) 
	{
		int unum=Integer.parseInt(request.getParameter("num"));
		String fname=request.getParameter("fname");
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ProductDTO dto=ps.pmodify1(unum);
		model.addAttribute("dto",dto);
		
		return "pmodify1";
	}
	@RequestMapping(value = "/pmodifysave")
	public String product6(MultipartHttpServletRequest mul) throws IllegalStateException, IOException 
	{
		int productnum=Integer.parseInt(mul.getParameter("productnum"));
		String id=mul.getParameter("id");
		String animal=mul.getParameter("animal");
		String productlist=mul.getParameter("productlist");
		int price=Integer.parseInt(mul.getParameter("price"));
		MultipartFile mf=mul.getFile("productimg");//이미지의 여러정보
		String dfname=mul.getParameter("himage");//기존이미지
		String fname=mf.getOriginalFilename();//파일명과 확장자
		UUID uu=UUID.randomUUID();
		fname=uu.toString()+"_"+fname;
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ps.pmodify2(productnum,id,animal,productlist,price,fname);
		mf.transferTo(new File(path+"\\"+fname));//수정이미지 저장
		mf.transferTo(new File(path+"\\"+dfname));
		File ff=new File(path+"\\"+dfname);
		ff.delete();
				
		return "redirect:/productout";
	}
	
	@RequestMapping(value = "/pdelete1")
	public String product7(HttpServletRequest request, Model model) 
	{
		int dnum=Integer.parseInt(request.getParameter("num"));
		String fname=request.getParameter("fname");
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ProductDTO dto=ps.pdelete1(dnum);
		model.addAttribute("dto",dto);
		
		return "pdelete1";
	}
	@RequestMapping(value = "/pdelete2")
	public String product8(HttpServletRequest request) 
	{
		int dnum=Integer.parseInt(request.getParameter("productnumber"));
		String dfname=request.getParameter("himage");
		
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ps.pdelete2(dnum);		
		File ff=new File(path+"\\"+dfname);
		ff.delete();	
		
		return "redirect:/";
	}
	
}

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ProductController {
	@Autowired
	SqlSession sqlSession;
	String path="C:\\Noljyu\\Team-noljyu\\src\\main\\webapp\\image";
	
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
			String productname=mul.getParameter("productname");
			ProductService ps=sqlSession.getMapper(ProductService.class);
			ps.productinput(id,animal,productlist,price,fname,productdate,productname);			
			
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
		String productdate=mul.getParameter("productdate");
		String productname=mul.getParameter("productname");
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ps.pmodify2(productnum,id,animal,productlist,price,fname,productdate,productname);
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
		int dnum=Integer.parseInt(request.getParameter("productnum"));
		String dfname=request.getParameter("himage");		
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ps.pdelete2(dnum);		
		File ff=new File(path+"\\"+dfname);
		ff.delete();	
		
		return "redirect:/productout";
	}
	
	
	@RequestMapping(value = "/productsearch")
	public String product9() 
	{
		return "psearch1";
	}
	
	@RequestMapping(value = "/psearch2")
	public String product10(HttpServletRequest request, Model model) 
	{
		String name=request.getParameter("scname");
		String value=request.getParameter("scvalue");
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ArrayList<ProductDTO>list=ps.psearch2(name,value);
		model.addAttribute("list", list);
				
		return "psearch2";
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "/dogproduct")
	public String product11(Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);
		ArrayList<ProductDTO>list=ps.productout();
		model.addAttribute("list",list);
		
		return "dogproduct";
=======
	@RequestMapping(value = "/dogproductmain")
	public String product11(HttpServletRequest request,Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);		
		ArrayList<ProductDTO>list=ps.dogproductout();
		model.addAttribute("list",list);
		
		return "dogproductmain";
	}
	
	@RequestMapping(value = "dogtoyliving")
	public String product12(HttpServletRequest request,Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);		
		ArrayList<ProductDTO>list=ps.dogtoyliving();
		model.addAttribute("list",list);
		
		return "dogtoyliving";
	}
	
	@RequestMapping(value = "/catproductmain")
	public String product16(HttpServletRequest request,Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);		
		ArrayList<ProductDTO>list=ps.catproductout();
		model.addAttribute("list",list);
		
		return "catproductmain";
	}

	@RequestMapping(value = "/birdproductmain")
	public String product21(HttpServletRequest request,Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);		
		ArrayList<ProductDTO>list=ps.birdproductout();
		model.addAttribute("list",list);
		
		return "birdproductmain";
	}
	
	@RequestMapping(value = "/fishproductmain")
	public String product26(HttpServletRequest request,Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);		
		ArrayList<ProductDTO>list=ps.fishproductout();
		model.addAttribute("list",list);
		
		return "fishproductmain";
	}
	
	@RequestMapping(value = "/creepproductmain")
	public String product31(HttpServletRequest request,Model model) 
	{
		ProductService ps=sqlSession.getMapper(ProductService.class);		
		ArrayList<ProductDTO>list=ps.creepproductout();
		model.addAttribute("list",list);
		
		return "creepproductmain";
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86
	}
	
}

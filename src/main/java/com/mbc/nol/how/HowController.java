package com.mbc.nol.how;

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
public class HowController {

	@Autowired
	SqlSession sqlsession;
	String path="C:\\MBC12AI\\spring\\noljyu\\src\\main\\webapp\\image";
	
	@RequestMapping(value = "howinput")
	public String hh1() {
		return "howinput";
	}
	
	@RequestMapping(value = "howsave")
	public String hh2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		String id=mul.getParameter("id");
		String howtitle=mul.getParameter("howtitle");
		String howdetail=mul.getParameter("howdetail");
		
		MultipartFile mf = mul.getFile("howimg");
		String howimg=mf.getOriginalFilename();
		UUID uu = UUID.randomUUID();
		howimg=uu.toString()+"="+howimg;
		System.out.println(id+" "+howtitle+" "+howdetail+ " "+howimg);
		HowService hs = sqlsession.getMapper(HowService.class);
		hs.howinsert(id,howtitle,howdetail,howimg);
		
		//mf.transferTo(new File(path+"\\"+howimg));
		
		return "main";
	}
	
	@RequestMapping(value = "howout")
	public String hh3(Model model) {
		HowService hs = sqlsession.getMapper(HowService.class);
		ArrayList<HowDTO> list = hs.howout();
		model.addAttribute("list", list);
		return "howout";
	}
	
	@RequestMapping(value = "howdetail")
	public String hh4(HttpServletRequest request, Model model) {
		int hownum = Integer.parseInt(request.getParameter("hownum"));
		HowService hs = sqlsession.getMapper(HowService.class);
		HowDTO dto = hs.howdetailout(hownum);
		ArrayList<HowReviewDTO> list = hs.howreviewout(hownum);
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		return "howdetail";
	}
	
	@RequestMapping(value = "howreviewsave")
	public String hh5(HttpServletRequest request, Model model) {
		int hownum=Integer.parseInt(request.getParameter("hownum"));
		String id = request.getParameter("id");
		String review=request.getParameter("review");
		HowService hs = sqlsession.getMapper(HowService.class);
		hs.howreview(hownum,id,review);
		//HowReviewDTO dot = hs.howreviewout();
		//model.addAttribute("dot", dot);
		return "redirect:/";
	}
	
	@RequestMapping(value = "howrere")
	public String hh6(HttpServletRequest request,Model model) {
		int reviewnum=Integer.parseInt(request.getParameter("reviewnum"));
		HowService hs = sqlsession.getMapper(HowService.class);
		HowReviewDTO dto = hs.howrere(reviewnum);
		model.addAttribute("dto", dto);
		return "howredetail";
	}
	
	@RequestMapping(value = "howreresave")
	public String hh7(HttpServletRequest request) {
		int hownum=Integer.parseInt(request.getParameter("hownum"));
		String id=request.getParameter("id");
		int groups=Integer.parseInt(request.getParameter("groups"));
		int step=Integer.parseInt(request.getParameter("step"));
		int indent=Integer.parseInt(request.getParameter("indent"));
		String review=request.getParameter("review");
		HowService hs = sqlsession.getMapper(HowService.class);
		hs.howstepup(groups,step);
		step++;
		indent++;
		hs.howreinsert(hownum, id,review,groups,step,indent);
		return "redirect:/";
	}
}

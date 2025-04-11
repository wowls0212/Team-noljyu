package com.mbc.nol.how;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class HowController {

	@Autowired
	SqlSession sqlsession;
	String path="C:\\Users\\320-22\\Downloads\\noljyu\\src\\main\\webapp\\image";
	
	//입력 페이지로 이동
	@RequestMapping(value = "/howinput")
	public String hh1() {
		return "howinput";
	}
	
	//게시글 DB 저장
	@RequestMapping(value = "/howsave")
	public String hh2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		String id=mul.getParameter("id");
		String howtitle=mul.getParameter("howtitle");
		String howdetail=mul.getParameter("howdetail");
		
		MultipartFile mf = mul.getFile("howimg");
		String howimg=mf.getOriginalFilename();
		UUID uu = UUID.randomUUID();
		howimg=uu.toString()+"-"+howimg;
		System.out.println(id+" "+howtitle+" "+howdetail+ " "+howimg);
		HowService hs = sqlsession.getMapper(HowService.class);
		hs.howinsert(id,howtitle,howdetail,howimg);
		
		mf.transferTo(new File(path+"\\"+howimg));
		
		return "main";
	}
	
	//게시글 출력
	@RequestMapping(value = "/howout")
	public String hh3(Model model) {
		HowService hs = sqlsession.getMapper(HowService.class);
		ArrayList<HowDTO> list = hs.howout();
		model.addAttribute("list", list);
		return "howout";
	}
	
	//게시글 상세내용, 댓글/대댓글 출력
	@RequestMapping(value = "/howdetail")
	public String hh4(HttpServletRequest request, Model model) {
		int hownum = Integer.parseInt(request.getParameter("hownum"));
		HowService hs = sqlsession.getMapper(HowService.class);
		HowDTO dto = hs.howdetailout(hownum);
		ArrayList<HowReviewDTO> list = hs.howreviewout(hownum);
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		return "howdetail";
	}
	
	//댓글 저장
	@RequestMapping(value = "/howreviewsave")
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
	
	//대댓글 입력 페이지
	@RequestMapping(value = "/howrere")
	public String hh6(HttpServletRequest request,Model model) {
		int reviewnum=Integer.parseInt(request.getParameter("reviewnum"));
		HowService hs = sqlsession.getMapper(HowService.class);
		HowReviewDTO dto = hs.howrere(reviewnum);
		model.addAttribute("dto", dto);
		return "howredetail";
	}
	
	//대댓글 DB 저장, 들여쓰기
	@RequestMapping(value = "/howreresave")
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
		hs.howreinsert(hownum,id,review,groups,step,indent);
		return "redirect:/";
	}
	
	//게시글 수정 페이지 이동
	@RequestMapping(value = "/howupdate")
	public String hh8(HttpServletRequest request, Model model) {
		int hownum=Integer.parseInt(request.getParameter("hownum"));
		HowService hs = sqlsession.getMapper(HowService.class);
		HowDTO dto = hs.howupdateout(hownum);
		model.addAttribute("dto", dto);
		return "howupdate";
	}
	
	//게시글 수정 사항 저장 
	@RequestMapping(value = "/howupdatesave")
	public String hh9(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		int hownum=Integer.parseInt(mul.getParameter("hownum"));
		String howtitle=mul.getParameter("howtitle");
		String howdetail=mul.getParameter("howdetail");
		
		MultipartFile mf = mul.getFile("howimg");
		String howimg = mf.getOriginalFilename();
		UUID uu = UUID.randomUUID();
		howimg=uu.toString()+"-"+howimg;
		
		String howoldimg = mul.getParameter("howoldimg");
		HowService hs = sqlsession.getMapper(HowService.class);
		
		if (mf == null || mf.isEmpty()) {
			hs.howupdate(hownum,howtitle,howdetail);
		}
		else {
			hs.howupdateimg(hownum,howtitle,howdetail,howimg);
			mf.transferTo(new File(path+"\\"+howimg));
			File ff = new File(path+"\\"+howoldimg);
			ff.delete();
		}
		
		return "redirect:/";
	}
	
	//게시글 삭제 ajax
	@ResponseBody
	@RequestMapping(value = "/howdelete")
	public String hh10(int hownum, HttpServletResponse response, HttpServletRequest request) {
		HowService hs = sqlsession.getMapper(HowService.class);
		hs.howdelete(hownum);
		int count = hs.howdeletecheck(hownum);
		String bigo="";
		if (count == 0 ) bigo = "success";
		else bigo = "fail";
		return bigo;
	}
	
	//게시글 검색
	@RequestMapping(value = "/howsearch")
	public String hh11(HttpServletRequest request,Model model) {
		String howkey = request.getParameter("howkey");
		String howvalue = request.getParameter("howvalue");
		HowService hs = sqlsession.getMapper(HowService.class);
		if (howkey.equals("all")) {
			ArrayList<HowDTO> alllist = hs.howsearchall(howvalue);
			model.addAttribute("list", alllist);
		}
		else {
			ArrayList<HowDTO> list = hs.howsearch(howkey,howvalue);
			model.addAttribute("list", list);
		}
		model.addAttribute("howvalue", howvalue);
		return "howsearch";
	}
}

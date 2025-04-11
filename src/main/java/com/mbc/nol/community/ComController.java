package com.mbc.nol.community;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@Controller
public class ComController {

	@Autowired
	SqlSession sqlsession;
	String path="C:\\Users\\320-22\\Downloads\\noljyu\\src\\main\\webapp\\image";
	@RequestMapping(value = "/cominput")
	public String cominput() {
		String path = "";
		return "cominput";
	}
	
	@RequestMapping(value = "/comsave")
	public String comsave(MultipartHttpServletRequest request) {
		String id = request.getParameter("id");
		String comtitle  = request.getParameter("comtitle");
		String comdetail = request.getParameter("comdetail");
		MultipartFile mf = request.getFile("comimg");
		String comimg = mf.getOriginalFilename();
		UUID uu = UUID.randomUUID();
		comimg = uu+"-"+comimg;
		//mf.transferTo(new File(path+"\\"+comimg));
		ComService cs = sqlsession.getMapper(ComService.class);
		cs.comsave(id, comtitle, comdetail, comimg);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/comout")
	public String comout(Model model) {
		ComService cs = sqlsession.getMapper(ComService.class);
		ArrayList<ComDTO> list = cs.comout();
		model.addAttribute("list", list);
		return "comout";
	}
	
	@RequestMapping(value = "/comdetail")
	public String comdetail(HttpServletRequest request, Model model) {
		int comnum = Integer.parseInt(request.getParameter("comnum"));
		ComService cs = sqlsession.getMapper(ComService.class);
		ComDTO dto = cs.comdetail(comnum);
		ArrayList<ComReviewDTO> list2 = cs.comreviewout(comnum);
		model.addAttribute("dto", dto);
		model.addAttribute("list2", list2);
		
		return "comdetail";
	}
	
	@RequestMapping(value = "/comreviewsave")
	public String comreviewsave(HttpServletRequest request) {
		int comnum = Integer.parseInt(request.getParameter("comnum"));
		String id = request.getParameter("id");
		String comreview = request.getParameter("comreview");
		ComService cs = sqlsession.getMapper(ComService.class);
		cs.comreview(comnum, id, comreview);
		return "redirect:/";
	}
	
	@RequestMapping(value = "comrere")
	public String comrere(HttpServletRequest request, Model model) {
		int comreviewnum = Integer.parseInt(request.getParameter("comreviewnum"));
		ComService cs = sqlsession.getMapper(ComService.class);
		ComReviewDTO dto = cs.comrere(comreviewnum);
		model.addAttribute("dto", dto);
		return "comredetail";
	}
	
	@RequestMapping(value = "comreresave")
	public String comreresave(HttpServletRequest request) {
		int comnum=Integer.parseInt(request.getParameter("comnum"));
		String id = request.getParameter("id");
		int comgroups = Integer.parseInt(request.getParameter("comgroups"));
		int comstep = Integer.parseInt(request.getParameter("comstep"));
		int comindent = Integer.parseInt(request.getParameter("comindent"));
		String comreview = request.getParameter("comreview");
		ComService cs = sqlsession.getMapper(ComService.class);
		cs.comstepup(comgroups,comstep);
		comstep++;
		comindent++;
		cs.comreinsert(comnum,id,comreview,comgroups,comstep,comindent);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/comupdate")
	public String comupdate(HttpServletRequest request, Model model) {
		int comnum=Integer.parseInt(request.getParameter("comnum"));
		ComService cs = sqlsession.getMapper(ComService.class);
		ComDTO dto = cs.comupdateout(comnum);
		model.addAttribute("dto", dto);
		return "comupdate";
	}
	
	@RequestMapping(value = "/comupdatesave")
	public String comupdatesave(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		int comnum=Integer.parseInt(mul.getParameter("comnum"));
		String comtitle=mul.getParameter("comtitle");
		String comdetail=mul.getParameter("comdetail");
		
		MultipartFile mf = mul.getFile("comimg");
		String comimg = mf.getOriginalFilename();
		UUID uu = UUID.randomUUID();
		comimg=uu.toString()+"-"+comimg;
		
		String comoldimg = mul.getParameter("comoldimg");
		ComService cs = sqlsession.getMapper(ComService.class);
		
		if (mf == null || mf.isEmpty()) {
			cs.comupdate(comnum,comtitle,comdetail);
		}
		else {
			cs.comupdateimg(comnum,comtitle,comdetail,comimg);
			mf.transferTo(new File(path+"\\"+comimg));
			File ff = new File(path+"\\"+comoldimg);
			ff.delete();
		}
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/comdelete")
	public String comdelete(int comnum, HttpServletResponse response, HttpServletRequest request) {
		ComService cs = sqlsession.getMapper(ComService.class);
		cs.comdelete(comnum);
		int count = cs.comdeletecheck(comnum);
		String bigo="";
		if (count == 0 ) bigo = "success";
		else bigo = "fail";
		return bigo;
	}
	
	//게시글 검색
	@RequestMapping(value = "/comsearch")
	public String comsearch(HttpServletRequest request,Model model) {
		String comkey = request.getParameter("comkey");
		String comvalue = request.getParameter("comvalue");
		ComService cs = sqlsession.getMapper(ComService.class);
		if (comkey.equals("all")) {
			ArrayList<ComDTO> alllist = cs.comsearchall(comvalue);
			model.addAttribute("list", alllist);
		}
		else {
			ArrayList<ComDTO> list = cs.comsearch(comkey,comvalue);
			model.addAttribute("list", list);
		}
		model.addAttribute("comvalue", comvalue);
		return "comsearch";
	}
	
}//controller

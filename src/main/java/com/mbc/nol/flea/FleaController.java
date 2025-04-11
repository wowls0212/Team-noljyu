package com.mbc.nol.flea;

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
public class FleaController {

	@Autowired
	SqlSession sqlsession;
	String path="C:\\MBC12AI\\spring\\noljyu\\src\\main\\webapp\\image";
	
	@RequestMapping(value = "fleainput")
	public String hh1() {
		return "fleainput";
	}
	
	@RequestMapping(value = "fleasave")
	public String hh2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		String id=mul.getParameter("id");
		String fleatitle=mul.getParameter("fleatitle");
		String fleadetail=mul.getParameter("fleadetail");
		
		MultipartFile mf = mul.getFile("fleaimg");
		String fleaimg=mf.getOriginalFilename();
		UUID uu = UUID.randomUUID();
		fleaimg=uu.toString()+"="+fleaimg;
		System.out.println(id+" "+fleatitle+" "+fleadetail+ " "+fleaimg);
		FleaService fs = sqlsession.getMapper(FleaService.class);
		fs.fleainsert(id,fleatitle,fleadetail,fleaimg);
		
		//mf.transferTo(new File(path+"\\"+fleaimg));
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "fleaout")
	public String hh3(Model model) {
		FleaService fs = sqlsession.getMapper(FleaService.class);
		ArrayList<FleaDTO> list = fs.fleaout();
		model.addAttribute("list", list);
		return "fleaout";
	}
	
	@RequestMapping(value = "fleadetail")
	public String hh4(HttpServletRequest request, Model model) {
		int fleanum = Integer.parseInt(request.getParameter("fleanum"));
		FleaService fs = sqlsession.getMapper(FleaService.class);
		FleaDTO dto = fs.fleadetailout(fleanum);
		ArrayList<FleaReviewDTO> list = fs.fleareviewout(fleanum);
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		return "fleadetail";
	}
	
	@RequestMapping(value = "fleareviewsave")
	public String hh5(HttpServletRequest request, Model model) {
		int fleanum=Integer.parseInt(request.getParameter("fleanum"));
		String id = request.getParameter("id");
		String fleareview=request.getParameter("fleareview");
		FleaService fs = sqlsession.getMapper(FleaService.class);
		fs.fleareview(fleanum,id,fleareview);
		//fleaReviewDTO dot = hs.fleareviewout();
		//model.addAttribute("dot", dot);
		return "redirect:/";
	}
	
	@RequestMapping(value = "flearere")
	public String hh6(HttpServletRequest request,Model model) {
		int fleareviewnum=Integer.parseInt(request.getParameter("fleareviewnum"));
		FleaService fs = sqlsession.getMapper(FleaService.class);
		FleaReviewDTO dto = fs.flearere(fleareviewnum);
		model.addAttribute("dto", dto);
		return "flearedetail";
	}
	
	@RequestMapping(value = "fleareresave")
	public String hh7(HttpServletRequest request) {
		int fleanum=Integer.parseInt(request.getParameter("fleanum"));
		String id=request.getParameter("id");
		int fleagroups=Integer.parseInt(request.getParameter("fleagroups"));
		int fleastep=Integer.parseInt(request.getParameter("fleastep"));
		int fleaindent=Integer.parseInt(request.getParameter("fleaindent"));
		String fleareview=request.getParameter("fleareview");
		FleaService fs = sqlsession.getMapper(FleaService.class);
		fs.fleastepup(fleagroups,fleastep);
		fleastep++;
		fleaindent++;
		fs.fleareinsert(fleanum, id,fleareview,fleagroups,fleastep,fleaindent);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/fleaupdate")
	public String fleaupdate(HttpServletRequest request, Model model) {
		int fleanum = Integer.parseInt(request.getParameter("fleanum"));
		FleaService fs = sqlsession.getMapper(FleaService.class);
		FleaDTO dto = fs.fleaupdateout(fleanum);
		model.addAttribute("dto", dto);
		return "fleaupdate";
	}
	
	@RequestMapping(value = "/fleaupdatesave")
	public String fleaupdatesave(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		int fleanum=Integer.parseInt(mul.getParameter("fleanum"));
		String fleatitle=mul.getParameter("fleatitle");
		String fleadetail=mul.getParameter("fleadetail");
		
		MultipartFile mf = mul.getFile("fleaimg");
		String fleaimg = mf.getOriginalFilename();
		UUID uu = UUID.randomUUID();
		fleaimg=uu.toString()+"-"+fleaimg;
		
		String fleaoldimg = mul.getParameter("fleaoldimg");
		FleaService fs = sqlsession.getMapper(FleaService.class);
		
		if (mf == null || mf.isEmpty()) {
			fs.fleaupdate(fleanum,fleatitle,fleadetail);
		}
		else {
			fs.fleaupdateimg(fleanum,fleatitle,fleadetail,fleaimg);
			mf.transferTo(new File(path+"\\"+fleaimg));
			File ff = new File(path+"\\"+fleaoldimg);
			ff.delete();
		}
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/fleadelete")
	public String fleadelete(int fleanum, HttpServletResponse response, HttpServletRequest request) {
		FleaService fs = sqlsession.getMapper(FleaService.class);
		fs.fleadelete(fleanum);
		int count = fs.fleadeletecheck(fleanum);
		String bigo="";
		if (count == 0 ) bigo = "success";
		else bigo = "fail";
		return bigo;
	}
	
	//게시글 검색
	@RequestMapping(value = "/fleasearch")
	public String fleasearch(HttpServletRequest request,Model model) {
		String fleakey = request.getParameter("fleakey");
		String fleavalue = request.getParameter("fleavalue");
		FleaService fs = sqlsession.getMapper(FleaService.class);
		if (fleakey.equals("all")) {
			ArrayList<FleaDTO> alllist = fs.fleasearchall(fleavalue);
			model.addAttribute("list", alllist);
		}
		else {
			ArrayList<FleaDTO> list = fs.fleasearch(fleakey,fleavalue);
			model.addAttribute("list", list);
		}
		model.addAttribute("fleavalue", fleavalue);
		return "fleasearch";
	}
	
}

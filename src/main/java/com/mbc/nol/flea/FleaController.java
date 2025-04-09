package com.mbc.nol.flea;

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

import com.mbc.nol.how.HowDTO;
import com.mbc.nol.how.HowReviewDTO;
import com.mbc.nol.how.HowService;

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
		fs.howinsert(id,fleatitle,fleadetail,fleaimg);
		
		//mf.transferTo(new File(path+"\\"+fleaimg));
		
		return "main";
	}
	
	@RequestMapping(value = "fleaout")
	public String hh3(Model model) {
		FleaService fs = sqlsession.getMapper(FleaService.class);
		ArrayList<FleaDTO> list = fs.howout();
		model.addAttribute("list", list);
		return "fleaout";
	}
	
	@RequestMapping(value = "fleadetail")
	public String hh4(HttpServletRequest request, Model model) {
		int fleanum = Integer.parseInt(request.getParameter("fleanum"));
		FleaService fs = sqlsession.getMapper(FleaService.class);
		HowDTO dto = fs.howdetailout(fleanum);
		ArrayList<HowReviewDTO> list = fs.howreviewout(fleanum);
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		return "howdetail";
	}
	
	@RequestMapping(value = "fleareviewsave")
	public String hh5(HttpServletRequest request, Model model) {
		int fleanum=Integer.parseInt(request.getParameter("fleanum"));
		String id = request.getParameter("id");
		String fleareview=request.getParameter("fleareview");
		FleaService fs = sqlsession.getMapper(FleaService.class);
		fs.howreview(fleanum,id,fleareview);
		//HowReviewDTO dot = hs.howreviewout();
		//model.addAttribute("dot", dot);
		return "redirect:/";
	}
	
	@RequestMapping(value = "flearere")
	public String hh6(HttpServletRequest request,Model model) {
		int fleareviewnum=Integer.parseInt(request.getParameter("fleareviewnum"));
		FleaService fs = sqlsession.getMapper(FleaService.class);
		HowReviewDTO dto = fs.howrere(fleareviewnum);
		model.addAttribute("dto", dto);
		return "howredetail";
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
		fs.howstepup(fleagroups,fleastep);
		fleastep++;
		fleaindent++;
		fs.howreinsert(fleanum, id,fleareview,fleagroups,fleastep,fleaindent);
		return "redirect:/";
	}
	
}

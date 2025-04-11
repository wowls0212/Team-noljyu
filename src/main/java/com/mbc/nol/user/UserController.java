package com.mbc.nol.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class UserController {
@Autowired
SqlSession sqlSession;

@RequestMapping(value = "/userinput")
public String mm1() {
	return "userinput";
}
@ResponseBody
@RequestMapping(value ="/idcheck2")
public String mm2(String id) {
   UserService us=sqlSession.getMapper(UserService.class);
   int count= us.idcount(id);
   String bigo="";
   if(count ==1)
   {
	   bigo="no";
   }
   else
   {
	   bigo="ok";
   }
return bigo;
}
@RequestMapping(value = "/usersave")
public String mm3(UserDTO dto) {
	String id=dto.getId();
	String pw=dto.getPw();
	String name=dto.getName();
	String address=dto.getAddress();
	String phone=dto.getPhone();
	String nickname=dto.getNickname();
	String myanimal=dto.getMyanimal();
	//String admin=dto.getAdmin();
	PasswordEncoder pe = new BCryptPasswordEncoder();
	pw=pe.encode(pw);
	UserService us=sqlSession.getMapper(UserService.class);
			us.insertq(id,pw,name,address,phone,nickname,myanimal);	
	return "redirect:/main";
}
@RequestMapping(value = "/userout")
public ModelAndView mm4(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
	HttpSession hs= request.getSession();
	boolean flag=(boolean)hs.getAttribute("loginstate");
	if(flag)
	{
		UserService us=sqlSession.getMapper(UserService.class);
		ArrayList<UserDTO>list=us.allout();
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("userout");
		return mav;
	}
	else
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pww= response.getWriter();
		pww.print("<script>alert('로그인후 사용하세요')</script>");
		pww.print("<script>location.href='login'</script>");
		pww.close();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/login");
		return mav;
	}	
}
	@RequestMapping(value = "/usersearch")
	public String sc1() {
	
	return"scearch";
	}
	@RequestMapping(value = "/scearch2")
	public String sc2(HttpServletRequest mul,Model model) {
		String cate=mul.getParameter("cate");
		String scearch=mul.getParameter("scearch");
		
		UserService us=sqlSession.getMapper(UserService.class);
		ArrayList<UserDTO>list = us.scearcha(cate,scearch);
		model.addAttribute("list", list);
		return"scearchout";
	}
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
	    HttpSession hs = request.getSession();
	    Boolean flag = (Boolean) hs.getAttribute("loginstate");

	    if (flag != null && flag) {
	        String loginId = (String) hs.getAttribute("id"); 
	        UserService us = sqlSession.getMapper(UserService.class);
	        UserDTO myinfo = us.getuser(loginId);

	        ModelAndView mav = new ModelAndView();
	        mav.addObject("myinfo", myinfo);
	        mav.setViewName("mypageout");
	        return mav;
	    } else {
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter pww = response.getWriter();
	        pww.print("<script>alert('로그인후 사용하세요'); location.href='login';</script>");
	        pww.close();
	        return null;
	    }
	}
	    @RequestMapping(value = "/modify1")
		public String mo1(HttpServletRequest request,Model model) {
	    	String id = request.getParameter("id");
			UserService us = sqlSession.getMapper(UserService.class);
			UserDTO dto=us.modify1(id);
			model.addAttribute("dto", dto);
			return"modify1";
	    }

		@RequestMapping(value = "/modifysave", method = RequestMethod.POST)
		public String mo2(HttpServletRequest mul) throws IllegalStateException, IOException {
			
			String id=mul.getParameter("id");
			String pw=mul.getParameter("pw");
			PasswordEncoder pe = new BCryptPasswordEncoder();
			pw = pe.encode(pw);
			String name=mul.getParameter("name");
			String address=mul.getParameter("address");
			String phone=mul.getParameter("phone");
			String nickname=mul.getParameter("nickname");
			String myanimal=mul.getParameter("myanimal");
			
			
			UserService us = sqlSession.getMapper(UserService.class);
			us.modify2(id,pw,name,address,phone,nickname,myanimal);
			return "redirect:/";
		}
	}

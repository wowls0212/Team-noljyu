package com.mbc.nol.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping(value ="")
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
return "bigo";
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

}

package com.mbc.nol.login;

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
public class LoginController {
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping (value = "/login")
	public String log1() {
		
		return "login";
	}
	
	@RequestMapping (value = "/logincheck")
	public String log2(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id= request.getParameter("id");
        String pw= request.getParameter("pw");
		LoginService ls= sqlSession.getMapper(LoginService.class);
		String cpw=ls.pwsearch(id);
		PasswordEncoder pe= new BCryptPasswordEncoder();
		boolean flag= pe.matches(pw, cpw);
		if(flag)
		{
			HttpSession hs= request.getSession();
			hs.setAttribute("loginstate", true);
			hs.setAttribute("id", id);
			return "redirect:/main";
		}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pww = response.getWriter();
			pww.print("<script>alert('���̵� or �н����尡 �ٸ��ϴ�.')</script>");
			pww.print("<script>alert('�ٽ� Ȯ���� �α��� ���ּ���.')</script>");
	    	pww.print("<script>location.href='login'</script>");
	    	pww.close();
			
			return "redirect:/login";
		}
	}
		@RequestMapping (value = "/logout")
		public String log4(HttpServletRequest request) {
			HttpSession hs= request.getSession();
			hs.removeAttribute("loginstate");
			hs.removeAttribute("id");
			hs.setAttribute("loginstate", false);
			
			return "redirect:/main";
		}
	}

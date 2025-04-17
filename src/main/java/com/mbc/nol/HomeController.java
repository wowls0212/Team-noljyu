package com.mbc.nol;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
=======
import org.springframework.web.servlet.ModelAndView;
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		hs.setAttribute("loginstate", false);

		return "main";
	}
<<<<<<< HEAD
	
	@RequestMapping(value = "/main")
	public String main() {
		
		return "main";
	}
	
=======

	@RequestMapping(value = "/main")
	public ModelAndView main(HttpSession session) {
		String admin = (String) session.getAttribute("admin");
		ModelAndView mav = new ModelAndView("main");

		if ("admin".equals(admin)) {
			mav.addObject("topPath", "/WEB-INF/views/top.jsp");
		} else {
			mav.addObject("topPath", "/WEB-INF/views/top_user.jsp");
		}

		return mav;
	}

>>>>>>> 8546762916583da98135734a1f7933dd5da22e86
}

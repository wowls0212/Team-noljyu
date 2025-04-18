package com.mbc.nol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(HttpServletRequest request) {
        HttpSession hs = request.getSession();
        hs.setAttribute("loginstate", false);
        return "main";
    }

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

}

package com.mbc.nol.login;

<<<<<<< HEAD
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

=======
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
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
			pww.print("<script>alert('아이디 or 패스워드가 다릅니다.')</script>");
			pww.print("<script>alert('다시 확인후 로그인 해주세요.')</script>");
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
=======
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    SqlSession sqlSession;

    // 濡쒓렇�씤 �럹�씠吏�
    @RequestMapping("/login")
    public String loginPage() {
        return "login"; 
    }

    // �씪諛� 濡쒓렇�씤 泥댄겕
    @RequestMapping("/logincheck")
    public String loginCheck(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        LoginService loginService = sqlSession.getMapper(LoginService.class);
        String encodedPw = loginService.pwsearch(id);

        PasswordEncoder pe = new BCryptPasswordEncoder();

        if (encodedPw != null && pe.matches(pw, encodedPw)) {
            HttpSession session = request.getSession();
            session.setAttribute("loginstate", true);
            session.setAttribute("id", id);

            String adminStatus = loginService.getAdminStatus(id);
            session.setAttribute("admin", adminStatus);
            session.setAttribute("msg", "�솚�쁺�빀�땲�떎, " + id + "�떂!");

            return "redirect:/main";
        } else {
            response.setContentType("text/html;charset=utf-8");
            try (java.io.PrintWriter out = response.getWriter()) {
                out.print("<script>alert('�븘�씠�뵒 �삉�뒗 �뙣�뒪�썙�뱶媛� �떎由낅땲�떎.\\n�떎�떆 �솗�씤 �썑 濡쒓렇�씤 �빐二쇱꽭�슂.'); location.href='login';</script>");
            }
            return "redirect:/login";
        }
    }

    // 濡쒓렇�븘�썐
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/main";
    }
}
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86

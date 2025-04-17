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
=======
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    SqlSession sqlSession;

    // 로그인 페이지
    @RequestMapping("/login")
    public String loginPage() {
        return "login"; 
    }

    // 일반 로그인 체크
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
            session.setAttribute("msg", "환영합니다, " + id + "님!");

            return "redirect:/main";
        } else {
            response.setContentType("text/html;charset=utf-8");
            try (java.io.PrintWriter out = response.getWriter()) {
                out.print("<script>alert('아이디 또는 패스워드가 다릅니다.\\n다시 확인 후 로그인 해주세요.'); location.href='login';</script>");
            }
            return "redirect:/login";
        }
    }

    // 로그아웃
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/main";
    }
}
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86

package com.mbc.nol.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Autowired
	SqlSession sqlSession;

	// 로그인 페이지로 이동
	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	// 로그인 처리
	@RequestMapping(value = "/logincheck")
	public String loginCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		LoginService loginService = sqlSession.getMapper(LoginService.class);
		String encodedPw = loginService.pwsearch(id);

		PasswordEncoder pe = new BCryptPasswordEncoder();

		if (encodedPw != null && pe.matches(pw, encodedPw)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginstate", true);
			session.setAttribute("id", id);

			// 관리자 여부 세션 저장
			String adminStatus = loginService.getAdminStatus(id);
			session.setAttribute("admin", adminStatus);

			return "redirect:/main";
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('아이디 또는 패스워드가 다릅니다.\\n다시 확인 후 로그인 해주세요.'); location.href='login';</script>");
			out.close();
			return "redirect:/login";
		}
	}

	// 로그아웃 처리
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate(); // 모든 세션 데이터 제거
		return "redirect:/main";
	}
}

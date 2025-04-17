package com.mbc.nol.user;

<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86

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
<<<<<<< HEAD
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
public String mm3(UserDTO dto,HttpServletRequest request,Model model) {
	String id=dto.getId();
	String pw=dto.getPw();
	String name=dto.getName();
	String address=dto.getAddress();
	String phone=dto.getPhone();
	String nickname=dto.getNickname();
	String myanimal=dto.getMyanimal();
	String admin=dto.getAdmin();
	String inputAdminPass = request.getParameter("adminPass");
	PasswordEncoder pe = new BCryptPasswordEncoder();
	pw=pe.encode(pw);
	
	UserService us=sqlSession.getMapper(UserService.class);
	
	 // 관리자 등록 요청 시 관리자용 비밀번호 확인
    if ("admin".equals(admin)) {
        String savedAdminPass = us.getAdminPassword();
        if (!pe.matches(inputAdminPass, savedAdminPass)) {
            model.addAttribute("msg", "관리자용 비밀번호가 일치하지 않습니다.");
            return "userinput"; // 다시 가입 페이지로
        }
    }
    
			us.insertq(id,pw,name,address,phone,nickname,myanimal,admin);	
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
		pww.print("<script>alert('濡쒓렇�씤�썑 �궗�슜�븯�꽭�슂')</script>");
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
	public String mypage(Model model, HttpServletRequest request) {
	    String loginId = request.getParameter("id");
	    UserService us = sqlSession.getMapper(UserService.class);
	    UserDTO myinfo = us.getuser(loginId);
	    model.addAttribute("myinfo", myinfo);
	    return "mypageout";
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
	    public String mo2(HttpServletRequest mul){
	    	String id = mul.getParameter("id");
	        String pw = mul.getParameter("pw");
	        PasswordEncoder pe = new BCryptPasswordEncoder();
	        pw = pe.encode(pw);
	        String name = mul.getParameter("name");
	        String address = mul.getParameter("address");
	        String phone = mul.getParameter("phone");
	        String nickname = mul.getParameter("nickname");
	        String myanimal = mul.getParameter("myanimal");

	        UserService us = sqlSession.getMapper(UserService.class);
	        us.modify2(id, pw, name, address, phone, nickname, myanimal);

	        return "redirect:/main";
	    }
		@RequestMapping(value = "/delete1")
		public String del(HttpSession session, Model model) {
		    String id = (String) session.getAttribute("id");
		    if (id == null) {
		        return "redirect:/login"; // 로그인 안 되어 있으면 로그인 페이지로
		    }

		    UserService us = sqlSession.getMapper(UserService.class);
		    UserDTO dto = us.delete1(id);
		    model.addAttribute("dto", dto);

		    return "deleteview"; // 탈퇴 확인 페이지로 이동
		}

		@RequestMapping(value = "/delete2", method = RequestMethod.POST)
		public String del2(HttpSession session) {
		    String id = (String) session.getAttribute("id");
		    if (id == null) {
		        return "redirect:/login"; // 로그인 상태 확인
		    }

		    UserService us = sqlSession.getMapper(UserService.class);
		    us.delete2(id); // DB에서 유저 삭제

		    session.invalidate(); // 세션 무효화

		    return "redirect:/main"; // 메인으로 이동
		}
=======
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	// 닉네임 중복 검사
	@ResponseBody
	@RequestMapping(value = "/nicknamecheck", method = RequestMethod.POST)
	public String nicknameCheck(String nickname) {
	    UserService us = sqlSession.getMapper(UserService.class);
	    int count = us.nicknamecount(nickname);
	    String bigo = "";
		if (count == 1) {
			bigo = "no";
		} else {
			bigo = "ok";
		}
		return bigo;
	}

	// 회원가입 처리
	@RequestMapping(value = "/usersave")
	public String userSave(UserDTO dto, HttpServletRequest request, HttpSession session, Model model) {
	    PasswordEncoder pe = new BCryptPasswordEncoder();
	    String encodedPw = pe.encode(dto.getPw());

	    UserService us = sqlSession.getMapper(UserService.class);

	    // 닉네임 중복 최종 확인 추가
	    if (us.nicknamecount(dto.getNickname()) > 0) {
	        model.addAttribute("msg", "이미 사용 중인 닉네임입니다.");
	        return "userinput";
	    }

	    // 관리자용 비밀번호 확인 로직
	    if ("admin".equals(dto.getAdmin())) {
	        String inputAdminPass = request.getParameter("adminPass");
	        String savedAdminPass = us.getAdminPassword();

	        if (savedAdminPass == null || !savedAdminPass.startsWith("$2") 
	        	|| !pe.matches(inputAdminPass, savedAdminPass)) {
	     	
	            model.addAttribute("msg", "관리자용 비밀번호가 일치하지 않습니다.");
	            return "userinput";
	        }
	    }

	    // 저장 실행
		us.insertq(dto.getId(), encodedPw, dto.getName(), dto.getAddress(), dto.getPhone(), dto.getNickname(),
				dto.getMyanimal(), dto.getAdmin());

		session.setAttribute("msg", "환영합니다! 회원가입이 완료되었습니다.");
		return "redirect:/main";
	}


	// 회원 목록 출력
	@RequestMapping(value = "/userout")
	public ModelAndView userOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession hs = request.getSession();
		Boolean flag = (Boolean) hs.getAttribute("loginstate");

		if (flag != null && flag) {
			UserService us = sqlSession.getMapper(UserService.class);
			ArrayList<UserDTO> list = us.allout();
			ModelAndView mav = new ModelAndView("userout");
			mav.addObject("list", list);
			return mav;
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 후 이용하세요.'); location.href='login';</script>");
			out.close();
			return new ModelAndView("redirect:/login");
		}
	}
	
	// 회원 정보 삭제
	@RequestMapping(value = "/admindelete", method = RequestMethod.POST)
	public String adminDelete(HttpServletRequest request, HttpSession session) {
	    String id = request.getParameter("id");

	    UserService us = sqlSession.getMapper(UserService.class);
	    us.delete2(id); // 삭제 수행

	    session.setAttribute("msg", "회원 삭제가 완료되었습니다.");
	    return "redirect:/userout";
	}
	// 검색 페이지 이동
	@RequestMapping(value = "/usersearch")
	public String userSearchPage() {
		return "scearch";
	}

	// 검색 처리
	@RequestMapping(value = "/scearch2")
	public String userSearchResult(HttpServletRequest request, Model model) {
		String cate = request.getParameter("cate");
		String keyword = request.getParameter("scearch");

		UserService us = sqlSession.getMapper(UserService.class);
		ArrayList<UserDTO> list = us.searcha(cate, keyword);
		model.addAttribute("list", list);
		return "scearchout";
	}

	// 마이페이지
	@RequestMapping(value = "/mypage")
	public String myPage(Model model, HttpServletRequest request) {
		String loginId = request.getParameter("id");
		UserService us = sqlSession.getMapper(UserService.class);
		UserDTO myinfo = us.getuser(loginId);
		model.addAttribute("myinfo", myinfo);
		return "mypageout";
	}

	// 회원정보 수정 폼
	@RequestMapping(value = "/modify1")
	public String modifyForm(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		UserService us = sqlSession.getMapper(UserService.class);
		UserDTO dto = us.modify1(id);
		model.addAttribute("dto", dto);
		return "modify1";
	}

	// 회원정보 수정 저장
	@RequestMapping(value = "/modifysave", method = RequestMethod.POST)
	public String modifySave(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String pwInput = request.getParameter("pw");
		String pw = null;

		// 비밀번호가 입력되었을 때만 암호화
		if (pwInput != null && !pwInput.trim().isEmpty()) {
			pw = new BCryptPasswordEncoder().encode(pwInput);
		}

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		String myanimal = request.getParameter("myanimal");

		UserService us = sqlSession.getMapper(UserService.class);

		if (pw != null) {
			us.modify2(id, pw, name, address, phone, nickname, myanimal);
		} else {
			// 비밀번호는 그대로 유지할 경우, 기존 비밀번호 유지
			UserDTO dto = us.getuser(id);
			us.modify2(id, dto.getPw(), name, address, phone, nickname, myanimal);
		}

		session.setAttribute("msg", "회원정보가 수정되었습니다.");
	    return "redirect:/main";
	}

	// 회원 탈퇴 확인
	@RequestMapping(value = "/delete1")
	public String deletePage(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		if (id == null)
			return "redirect:/login";

		UserService us = sqlSession.getMapper(UserService.class);
		UserDTO dto = us.delete1(id);
		model.addAttribute("dto", dto);
		return "deleteview";
	}

	// 회원 탈퇴 처리
	@RequestMapping(value = "/delete2", method = RequestMethod.POST)
	public String deleteConfirm(HttpServletRequest request, HttpSession session) {
		String id = (String) session.getAttribute("id");
		if (id == null)
			return "redirect:/login";

		UserService us = sqlSession.getMapper(UserService.class);
		us.delete2(id);
		session.invalidate();
		
		 // 새로운 세션에서 메시지 저장
	    HttpSession newSession = request.getSession();
	    newSession.setAttribute("msg", "회원 탈퇴가 완료되었습니다.");
	    return "redirect:/main";
	}

	// 비밀번호 확인 페이지 이동
	@RequestMapping("/pwcheck")
	public String pwCheckPage(HttpServletRequest request, Model model) {
		String type = request.getParameter("type");
		model.addAttribute("type", type);
		return "pwcheck"; // 비밀번호 확인 jsp
	}

	// 비밀번호 확인 처리
	@RequestMapping(value = "/pwcheckdo", method = RequestMethod.POST)
	public String pwCheckDo(HttpServletRequest request, HttpSession session, Model model) {
		String inputPw = request.getParameter("pw");
		String type = request.getParameter("type");
		String id = (String) session.getAttribute("id");

		if (id == null)
			return "redirect:/login";

		UserService us = sqlSession.getMapper(UserService.class);
		UserDTO dto = us.getuser(id);

		PasswordEncoder pe = new BCryptPasswordEncoder();
		if (dto != null && pe.matches(inputPw, dto.getPw())) {
			// 비밀번호 일치: 목적 페이지로 이동
			if ("modify".equals(type)) {
				return "redirect:/modify1?id=" + id;
			} else if ("delete".equals(type)) {
				return "redirect:/delete1";
			}
		}

		// 비밀번호 불일치
		model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
		model.addAttribute("type", type);
		return "pwcheck";
	}

>>>>>>> 8546762916583da98135734a1f7933dd5da22e86
}

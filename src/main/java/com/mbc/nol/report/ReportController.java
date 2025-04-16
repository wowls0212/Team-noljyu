package com.mbc.nol.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbc.nol.how.HowService;

@Controller
public class ReportController {
	
	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "postreportsave")
	public String ppsave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int postnum = Integer.parseInt(request.getParameter("postnum"));
		String postid = request.getParameter("postid");
		String reason = request.getParameter("reportreason");
		String detail = request.getParameter("reportdetail");
		String reportid = request.getParameter("reportid");
		ReportService rs = sqlsession.getMapper(ReportService.class);
		rs.save(postnum,postid,reason,reportid,detail);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<script type='text/javascript'>");
		out.print("self.close(); window.reload();");
		out.print("</script>");
		out.flush();
		
		return null;
	}
	
	@RequestMapping(value = "postreportout")
	public String postreportout(Model model) {
		ReportService rs = sqlsession.getMapper(ReportService.class);
		ArrayList<ReportDTO> list = rs.postreportout();
		model.addAttribute("list", list);
		return "reportout";
	}
	
	
	@RequestMapping(value = "reviewreportsave")
	public String resave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int postnum = Integer.parseInt(request.getParameter("postnum"));
		int reviewnum = Integer.parseInt(request.getParameter("postreviewnum"));
		String id = request.getParameter("postid");
		String reason = request.getParameter("reportreason");
		String detail = request.getParameter("reportdetail");
		String reportid = request.getParameter("reportid"); 
		ReportService rs = sqlsession.getMapper(ReportService.class);
		rs.resave(postnum,reviewnum,id,reason,detail,reportid);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<script type='text/javascript'>");
		out.print("self.close(); window.reload();");
		out.print("</script>");
		out.flush();
		return null;
	}
	
	@RequestMapping(value = "reviewreportout")
	public String rereport(Model model) {
		ReportService rs = sqlsession.getMapper(ReportService.class);
		ArrayList<ReportDTO> list = rs.rereportout();
		model.addAttribute("list", list);
		return "reviewreportout";
		
	}
	

}

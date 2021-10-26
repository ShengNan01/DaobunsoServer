package profiles.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import register.model.MemberBean;
import register.service.MemberService;
import util.GlobalService;

@WebServlet("/Change_pswd")
public class Change_pswd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
		String enPswd = GlobalService.encryptString(member.getPassword());
		MemberService ms = ctx.getBean(MemberService.class);
		System.out.println(member.getPassword() +"會員ID= " + member.getMemberId());
		ms.updateMemberPassword(enPswd,member.getMemberId());
		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(gson.toJson(bean));
		
//		if (ms.existsByMemberAccount(member.getAccount())){
//			response.setContentType("application/json");
//			response.setCharacterEncoding("UTF-8");
//			response.getWriter().write("已有重複帳號，請更改");
//		}else{
//		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
//		MemberBean bean = new MemberBean(null,member.getEmail(),member.getAccount()
//							,enPswd,member.getMember_name(),ts);
//		ms.save(bean);
//
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write("註冊成功，請重新登入");
//		}
	}
}

package register.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import register.model.MemberBean;
import register.service.MemberService;
import register.service.impl.MemberServiceImpl;
import util.GlobalService;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
//		System.out.println(member.getAccount());
//		System.out.println(member.getEmail());
//		System.out.println(member.getMember_name());
//		System.out.println(member.getPassword());
		String enPswd = GlobalService.encryptString(member.getPassword());
//		System.out.println(enPswd);
		MemberService ms = new MemberServiceImpl();
		if (ms.existsByMemberAccount(member.getAccount())){
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("已有重複帳號，請更改");
		}else{
		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		MemberBean bean = new MemberBean(null,member.getEmail(),member.getAccount()
							,enPswd,member.getMember_name(),ts);
		ms.save(bean);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("註冊成功，請重新登入");
		}
	}

}

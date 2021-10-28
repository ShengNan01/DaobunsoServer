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
	String decryptPassword;
	String EncryptPassword;
	MemberBean member;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
		//下面開始比對密碼(先呼叫service，再呼叫dao)
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
//		String enPswd = GlobalService.encryptString(member.getPassword());
		MemberService ms = ctx.getBean(MemberService.class);
		System.out.println(member.getPassword() +"會員ID= " + member.getMemberId());
//		ms.updateMemberPassword(enPswd,member.getMemberId());
		
				
		Integer memberId = member.getMemberId();
		String  Password = member.getPassword();
		
		//解密
		EncryptPassword = ms.findById(memberId).getPassword();
		decryptPassword = GlobalService.decryptString(GlobalService.KEY, EncryptPassword);
		//比對密碼
		System.out.println("輸入密碼 = " + Password);
		if (Password.equals(decryptPassword)) {
			System.out.println("密碼比對正確");
			member = ms.findById(memberId);
		//更新密碼
			String enPswd = GlobalService.encryptString(Password);
			ms.updateMemberPassword(enPswd,member.getMemberId());
			System.out.println( "會員ID= " + memberId + "會員密碼= " + Password);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("修改密碼成功，請重新登入");		
		}else {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("修改密碼失敗，請重新輸入！");
		}

	}
		
}


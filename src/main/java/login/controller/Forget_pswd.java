//package login.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import com.google.gson.Gson;
//
//import register.model.MemberBean;
//import register.service.MemberService;
//import util.GlobalService;
//
//@WebServlet("/Forget_pswd")
//public class Forget_pswd extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	MemberBean member;
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		Gson gson = new Gson();
//		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
//		//下面開始比對密碼(先呼叫service，再呼叫dao)
//		ServletContext sc = getServletContext();
//		WebApplicationContext ctx = WebApplicationContextUtils
//									 .getWebApplicationContext(sc);
//		MemberService ms = ctx.getBean(MemberService.class);
////		ms.updateMemberPassword(enPswd,member.getMemberId());
//		
//		String Account = member.getAccount();
//		String Email = member.getEmail();
//		String Password = member.getNewPassword();
//		System.out.println("會員帳號 =" + Account + "會員信箱 =" +Email + "會員輸入的新密碼 =" +Password);
//		
//		
//	if(ms.existsByMemberAccount(Account) && ms.existsByMemberEmail(Email)) {	
//		String enPswd = GlobalService.encryptString(Password);
//		ms.updateMemberForgetPassword(enPswd, Account);
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write("Success");		
//	}else {
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write("Fail");
//	}
//	}
//		
//}


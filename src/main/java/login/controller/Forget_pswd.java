package login.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import login.service.LoginService;
import register.model.MemberBean;
import register.service.MemberService;
import util.MailUtils;

@WebServlet("/Forget_pswd")
public class Forget_pswd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String decryptPassword;
	String EncryptPassword;
	MemberBean member;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
		System.out.println(member.getAccount() + member.getEmail());
//		System.out.println(member.getEmail()+ member.getMemberId());
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
		MemberService ms = ctx.getBean(MemberService.class);
		LoginService ls = ctx.getBean(LoginService.class);
		if(ms.existsByMemberEmail(member.getEmail()) && ls.findInfoByMemberAccount(member.getAccount()).getEmail().equals(member.getEmail())) {
			String emailMsg = "請點擊<a href='http://localhost:8080/Daobunso_Project/forget&change_pswd.html"
		            +"'>點擊修改密碼</a>";
		        System.out.println("正在發送郵件...");
		        new Thread(){
		            @Override
		            public void run(){
				        try {
				            //發送郵件
				            try {
								MailUtils.sendMail(member.getEmail(), emailMsg);
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
				        } catch (AddressException e) {
				            e.printStackTrace();
				        } catch (MessagingException e) {
				            e.printStackTrace();
				        } catch (GeneralSecurityException e) {
				            e.printStackTrace();
				        }
				        System.out.println("發送郵件成功!");
		            }
		          }.start();
		        response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("Success");
		}else {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Fail");
		}
	}
}



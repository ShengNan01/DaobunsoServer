package profiles.controller;

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

import register.model.MemberBean;
import register.service.MemberService;
import util.MailUtils;
@WebServlet("/Verifyemail")
public class Verifyemail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
		System.out.println(member.getEmail());
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
		MemberService ms = ctx.getBean(MemberService.class);
		if(ms.existsByMemberEmail(member.getEmail())) {
			String emailMsg = "請點擊<a href='http://localhost:8080/jspExercise/emailtest.html?method=active&activeCode="
		            +"'>修改密碼</a>";
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
				        System.out.println("發送郵件成功");
		            }
		          }.start();
		        response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("信件發送成功!");
				response.sendRedirect("/personal_info.html");
		}else {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("必須輸入註冊的電子信箱");
		}
	}

}

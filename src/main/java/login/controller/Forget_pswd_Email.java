//package login.controller;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.security.GeneralSecurityException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;
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
//import login.service.LoginService;
//import register.model.MemberBean;
//import register.service.MemberService;
//import util.MailUtils;
//
//@WebServlet("/Forget_pswd_Email")
//public class Forget_pswd_Email extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	String decryptPassword;
//	String EncryptPassword;
//	MemberBean member;
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		Gson gson = new Gson();
//		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
//		System.out.println(member.getAccount() + member.getEmail());
//		
//		Map<String,Object> info = new HashMap<>();
//		String account = member.getAccount();
//		String email = member.getEmail();
//		
//		ServletContext sc = getServletContext();
//		WebApplicationContext ctx = WebApplicationContextUtils
//									 .getWebApplicationContext(sc);
//		MemberService ms = ctx.getBean(MemberService.class);
//		LoginService ls = ctx.getBean(LoginService.class);
//		boolean exist = ms.existsByMemberAccount(account) && ms.existsByMemberEmail(email);
//		//如果帳密存在於資料庫，就寫進map，準備傳到前端
//		System.out.println("===資料寫回前端===");
//		if(exist) {
//			info.put("checkmemberinfo","ok");
//			info.put("member_account", account);
//			info.put("member_email", email);
//			response.setContentType("application/json");
//			response.setCharacterEncoding("UTF-8");
//			System.out.println("===開始寄送驗證信===");
//				if(ms.existsByMemberEmail(member.getEmail()) && ls.findInfoByMemberAccount(member.getAccount()).getEmail().equals(member.getEmail())) {
//					String emailMsg = "請點擊<a href='http://localhost:8080/Daobunso_Project/forget&change_pswd.html"
//				            +"'>點擊修改密碼</a>";
//				        System.out.println("正在發送郵件...");
//				        new Thread(){
//				            @Override
//				            public void run(){
//						        try {
//						            //發送郵件
//						            try {
//										MailUtils.sendMail(member.getEmail(), emailMsg);
//									} catch (UnsupportedEncodingException e) {
//										e.printStackTrace();
//									}
//						        } catch (AddressException e) {
//						            e.printStackTrace();
//						        } catch (MessagingException e) {
//						            e.printStackTrace();
//						        } catch (GeneralSecurityException e) {
//						            e.printStackTrace();
//						        }
//						        System.out.println("發送郵件成功!");
//				            }
//				          }.start();
//				        response.setContentType("application/json");
//						response.setCharacterEncoding("UTF-8");
//						info.put("sending","success");
//						response.getWriter().write(gson.toJson(info));
//				}else {
//					response.setContentType("application/json");
//					response.setCharacterEncoding("UTF-8");
//					info.put("sending","fail");
//					response.getWriter().write(gson.toJson(info));
//				}
//		}else if(!exist) {
//			System.out.println("===使用者傳送的資料錯誤===");
//			response.setContentType("application/json");
//			response.setCharacterEncoding("UTF-8");
//			info.put("checkmemberinfo", "notok");
//			response.getWriter().write(gson.toJson(info));
//		}
//	}
//}
//
//

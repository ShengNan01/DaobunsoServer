package login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import login.model.LoginBean;
import login.service.LoginService;
import register.model.MemberBean;
import register.service.MemberService;
import util.GlobalService;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String decryptPassword;
	String EncryptPassword;
	MemberBean member;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();

		LoginBean login = gson.fromJson(request.getReader(), LoginBean.class);


		Map<String,Object> info = new HashMap<>();

		if (login != null) {

			String account = login.getAccount();
			String password = login.getPassword();
			String rm = login.getRememberMe();
			System.out.println("RememberMe ===================================> " + rm); 

			// 下面開始判斷資料庫有無此筆帳密(先呼叫service，再呼叫dao)
			ServletContext sc = getServletContext();
			WebApplicationContext ctx = WebApplicationContextUtils
										 .getWebApplicationContext(sc);
			LoginService ls = ctx.getBean(LoginService.class);
			MemberService ms = ctx.getBean(MemberService.class);
			boolean exist = ms.existsByMemberAccount(account);

			// 如果帳號存在，就用account撈member資訊，判斷密碼是否等於資料庫解密後的密碼
			if (exist) {

				// 先解密
				EncryptPassword = ls.findPasswordByMemberAccount(account);
				decryptPassword = GlobalService.decryptString(GlobalService.KEY, EncryptPassword);

//				System.out.println(account + decryptPassword);

				// 解密後密碼與使用者輸入的密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)) {
					member = ls.findInfoByMemberAccount(account);
					info.put("Login", "OK");
					info.put("member_name", member.getMember_name());
					info.put("member_email", member.getEmail());
					info.put("member_id", member.getMemberId());
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					// response.setHeader("Refresh", "3;url='/frontpage.html'");
//					response.getWriter().write("登入成功");
					response.getWriter().write(gson.toJson(info));
					processCookies(request, response, account, password, rm);

				}
				// 如果密碼不正確，就顯示
				else {
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					info.put("Login", "NO");
					response.getWriter().write(gson.toJson(info));
				}
			}

			else {
				System.out.println("loginbean == null");
				response.setCharacterEncoding("UTF-8");
				info.put("Login", "NO");
				response.getWriter().write(gson.toJson(info));
			}
		}
	}
	
	private void processCookies(HttpServletRequest request, HttpServletResponse response, 
			String memberId, String password, String rm) {
	// **********Remember Me****************************
	Cookie cookieUser = null;
	Cookie cookiePassword = null;
	Cookie cookieRememberMe = null;
	String memberAccount = null;
	
	// 如果前端有勾選remember me，rm = true
	if (rm.equals("rememberOk")) {
		
		memberAccount = member.getAccount();
		cookieUser = new Cookie("account", memberAccount);
		cookieUser.setMaxAge(7 * 24 * 60 * 60); // Cookie的存活期: 七天
		cookieUser.setPath(request.getContextPath());
		
		cookiePassword = new Cookie("daobunsopppp", decryptPassword);
		cookiePassword.setMaxAge(7 * 24 * 60 * 60);
		cookiePassword.setPath(request.getContextPath());
		
		cookieRememberMe = new Cookie("rm", "true");
		cookieRememberMe.setMaxAge(7 * 24 * 60 * 60);
		cookieRememberMe.setPath(request.getContextPath());
	}
		else { // 使用者沒有對 RememberMe 打勾
		cookieUser = new Cookie("account", memberAccount);
		cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
		cookieUser.setPath(request.getContextPath());
		
		cookiePassword = new Cookie("daobunsopppp", decryptPassword);
		cookiePassword.setMaxAge(0);
		cookiePassword.setPath(request.getContextPath());
		
		cookieRememberMe = new Cookie("rm", "true");
		cookieRememberMe.setMaxAge(0);
		cookieRememberMe.setPath(request.getContextPath());
		}
	response.addCookie(cookieUser);
	response.addCookie(cookiePassword);
	response.addCookie(cookieRememberMe);

 }
}

package login.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import login.model.InfoBeanApp;
import login.model.LoginBean;
import login.service.LoginService;
import register.model.MemberBean;
import util.GlobalService;

@WebServlet("/LoginServletApp")
public class LoginServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String decryptPassword;
	String EncryptPassword;
	MemberBean member;
	InfoBeanApp info;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		
		
		JsonObject jsonObject = gson.fromJson(jsonIn.toString(), JsonObject.class);
		
		String loginbean = jsonObject.get("loginbean").getAsString();
		LoginBean login = gson.fromJson(loginbean, LoginBean.class);
		
		String account = login.getAccount();
		String password = login.getPassword();
		
		
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
		LoginService ls  = ctx.getBean(LoginService.class);
		
		info = new InfoBeanApp();
		String action = jsonObject.get("action").getAsString();

		if (action.equals("findmember") && login!=null) {
			
			if(ls.existsByMemberAccount(account)) { //核對確認有這個帳號
				EncryptPassword = ls.findPasswordByMemberAccount(account);
				decryptPassword = GlobalService.decryptString(GlobalService.KEY, EncryptPassword);

//				System.out.println(account + decryptPassword);

				// 解密後密碼與使用者輸入的密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)) {
					member = ls.findInfoByMemberAccount(account);
					info.setLogin("OK");
					
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					
					response.getWriter().write(gson.toJson(info));
//					processCookies(request, response, account, password, rm);

				}
				// 如果密碼不正確
				else {
					
					info.setLogin("NO");
					writeText(response, gson.toJson(info));
				}
			}

			else {
				
				info.setLogin("NO");
				writeText(response, gson.toJson(info));
			}
		
		}
	}
	private void writeText(HttpServletResponse response, String outText) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(outText);
		// 將輸出資料列印出來除錯用
		// System.out.println("output: " + outText);
	}

}


//writeText(response,"已有重複帳號，請更改");

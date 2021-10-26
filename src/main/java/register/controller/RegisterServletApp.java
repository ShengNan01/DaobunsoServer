package register.controller;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;
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
import com.google.gson.JsonObject;

import register.model.MemberBean;
import register.service.MemberService;
import util.GlobalService;

@WebServlet("/RegisterServletApp")
public class RegisterServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		
		String memberBean = jsonObject.get("memberBean").getAsString();
		MemberBean member = gson.fromJson(memberBean, MemberBean.class);
		
		
		String enPswd = GlobalService.encryptString(member.getPassword());
		
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
		MemberService ms  = ctx.getBean(MemberService.class);
		

		String action = jsonObject.get("action").getAsString();

		if (action.equals("memberInsert")) {
			// 將輸入資料列印出來除錯用
			System.out.println("input: " + jsonIn);
			if(ms.existsByMemberAccount(member.getAccount())) {
				writeText(response,"已有重複帳號，請更改");
			}
			else {
				Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
				MemberBean bean = new MemberBean(null,member.getEmail(),member.getAccount()
									,enPswd,member.getMember_name(),ts);
				ms.save(bean);
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

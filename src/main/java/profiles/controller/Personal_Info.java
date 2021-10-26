package profiles.controller;

import java.io.IOException;

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

@WebServlet("/Personal_Info")
public class Personal_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
		MemberService ms = ctx.getBean(MemberService.class);
		MemberBean bean = ms.findById(member.getMemberId());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(bean));
	}
}

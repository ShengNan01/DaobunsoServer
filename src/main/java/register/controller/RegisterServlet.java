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
		// String contextPath = request.getContextPath();
		// String name = "梯歐歪力";
		// String email = "grfmbiu324568@gmail.com";
		// String acconut = "123456";
		// String password = "123456";
		// Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		// password = GlobalService.getMD5Endocing(
		// 	     GlobalService.encryptString(password));
		// MemberService ms = new MemberServiceImpl();
		// MemberBean mb = new MemberBean(null, email, acconut, password, name, ts);
		// try {
		// 	ms.save(mb);
		// 	response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
		// 	return;
		// }catch(Exception ex) {
		// 	ex.printStackTrace();
		// 	System.out.println("資料新增失敗!");
		// }
		Gson gson = new Gson();
		MemberBean member = gson.fromJson(request.getReader(), MemberBean.class);
//		System.out.println(member.getAccount());
//		System.out.println(member.getEmail());
//		System.out.println(member.getMember_name());
//		System.out.println(member.getPassword());
		MemberService ms = new MemberServiceImpl();
		if (ms.existsByMemberName(member.getMember_name())){
			response.getWriter().write("已有重複帳號，請更改");
		}else{
		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		MemberBean bean = new MemberBean(null,member.getEmail(),member.getAccount()
							,member.getPassword(),member.getMember_name(),ts);
		ms.save(bean);
		response.getWriter().write("註冊成功，請重新登入");
		}
	}

}

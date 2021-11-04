package commentAPP.controller;

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

import commentAPP.model.CommentBean;
import commentAPP.service.CommentService;


@WebServlet("/CommentServletAPP")
public class CommentServletAPP extends HttpServlet {
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
		
		String commentBean = jsonObject.get("commentBean").getAsString();
		CommentBean cb = gson.fromJson(commentBean, CommentBean.class);
		
		
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc);
		CommentService cs  = ctx.getBean(CommentService.class);
		

		String action = jsonObject.get("action").getAsString();

		if (action.equals("commentInsert")) {
			// 將輸入資料列印出來除錯用
			System.out.println("input: " + jsonIn);
		
				Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
				CommentBean bean = new CommentBean(null,cb.getAccount(),cb.getStars(),ts,cb.getComment());
				cs.save(bean);
				writeText(response,"評論成功");

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

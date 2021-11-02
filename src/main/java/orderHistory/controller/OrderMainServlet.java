package orderHistory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import orderHistory.service.OrderService;


@WebServlet("/orderList.do")
public class OrderMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		Integer memberId = gson.fromJson(request.getReader(), Integer.class);  //反序列化JSON字串成對應的JAVA物件
		System.out.println(memberId); //ok

//		OrderService os = new OrderServiceImpl();
		
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc); //Spring
		OrderService os = ctx.getBean(OrderService.class);
	
		//凰喜方法
//		List<OrderBean> ob = os.findByMemberId(memberId);
//		System.out.println(ob);
		
		List<Object[]> lo = os.findInfoByMemberId(memberId);
		System.out.println(lo);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(lo));
		
		}
	}


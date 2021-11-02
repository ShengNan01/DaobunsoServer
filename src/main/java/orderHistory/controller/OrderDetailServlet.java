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

import orderHistory.service.OrderItemService;

@WebServlet("/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		Integer orderId = gson.fromJson(request.getReader(), Integer.class);
//		System.out.println(orderId); 
		
		ServletContext sc = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
									 .getWebApplicationContext(sc); //Spring
		OrderItemService ois = ctx.getBean(OrderItemService.class);
		
		List<Object[]> lo = ois.findByOrderId(orderId);
//		System.out.println(lo);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(lo));
		
		}
	}

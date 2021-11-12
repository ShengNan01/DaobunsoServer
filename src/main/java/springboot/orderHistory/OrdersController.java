package springboot.orderHistory;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.login.Login;
import springboot.login.LoginRepo;

@RestController
public class OrdersController {
	
	@Autowired
	OrdersResopository ordersResopository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	LoginRepo loginRepo;
	
	@GetMapping("/orders/{memberId}")
	public List<String[]> read(@PathVariable Integer memberId) {
		List<String[]> list = ordersResopository.findInfoByMemberId(memberId);
		return list;
	}
	@GetMapping("/orders/{memberId}/{orderId}")
	public List<String[]> read(@PathVariable (required = false) Integer memberId, @PathVariable Integer orderId) {
		List<String[]> list = orderDetailsRepository.findByOrderId(orderId);
		return list;
	}
	
//	@PostMapping("/app/getOrderBeans")
//	@ResponseBody
//	public List<OrderBean> getOrderBeans(@RequestBody Login loginBean) throws IOException {
//		
//		String ac = loginBean.getAccount();
//			
////		PrintWriter out = response.getWriter();
//		List<OrderBean> list = ordersResopository.findInfoByAccount(ac);
////        List<MyShop> shops = JsonService.getListShop();
////        StringBuffer sb = new StringBuffer();
////        sb.append('[');
////        for (OrderBean ob : list) {
////                sb.append('{').append("\"OrderId\":").append("\""+ob.getOrderId()+"\"").append(",");
////                sb.append("\"OrderDate\":").append("\""+ob.getOrderDate()+"\"").append(",");
////                sb.append("\"sum\":").append("\""+ob.getSum()+"\"").append(",");
////                sb.append('}').append(",");
////        }
////        sb.deleteCharAt(sb.length() - 1);
////        sb.append(']');
////        out.write(new String(sb));
////        out.flush();
////        out.close();
//		return list;
//	}
//	
	@PostMapping("/app/getOrderBeans")
	public List<String[]> getOrderBeans(@RequestBody Login loginbean) {
		
//		System.out.println(jason);
//		System.out.println("我是/app/getOrderBeans");
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
////		Date date = (Date) sdf.parse("2021-10-16 09:15:24");
////		Date date2 = (Date) sdf.parse("2021-10-29 14:36:25");
////		Date date3 = (Date) sdf.parse("2021-10-30 19:07:49");
		String account = loginbean.getAccount();
		System.out.println("account = " + account);
		Integer memberId = loginRepo.findMemberIdByAccount(account);
		System.out.println("memberId = " + memberId);
		List<String[]> list = ordersResopository.findInfoByMemberId(memberId);
//		List<OrderBean> list = new ArrayList<>();
//		OrderBean ob1 = new OrderBean(1,"鐘凰喜",100);
//		OrderBean ob2 = new OrderBean(2,"susan",200);
//		OrderBean ob3 = new OrderBean(3,"hsi",300);
	
//		list.add(ob1);	
//		list.add(ob2);
//		list.add(ob3);
		
		System.out.println(list.toString());
		return list;
	}


}

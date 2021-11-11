package springboot.orderHistory;

import java.io.IOException;
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

@RestController
public class OrdersController {
	
	@Autowired
	OrdersResopository ordersResopository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
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
	
	@PostMapping("app/getOrderBeans")
	@ResponseBody
	public List<OrderBean> getOrderBeans(@RequestBody Login loginBean) throws IOException {
		
		String ac = loginBean.getAccount();
			
//		PrintWriter out = response.getWriter();
		List<OrderBean> list = ordersResopository.findInfoByAccount(ac);
//        List<MyShop> shops = JsonService.getListShop();
//        StringBuffer sb = new StringBuffer();
//        sb.append('[');
//        for (OrderBean ob : list) {
//                sb.append('{').append("\"OrderId\":").append("\""+ob.getOrderId()+"\"").append(",");
//                sb.append("\"OrderDate\":").append("\""+ob.getOrderDate()+"\"").append(",");
//                sb.append("\"sum\":").append("\""+ob.getSum()+"\"").append(",");
//                sb.append('}').append(",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append(']');
//        out.write(new String(sb));
//        out.flush();
//        out.close();
		return list;
	}

}

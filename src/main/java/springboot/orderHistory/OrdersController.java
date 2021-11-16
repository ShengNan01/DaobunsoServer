package springboot.orderHistory;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/app/getOrderBeans")
	public List<String[]> getOrderBeans(@RequestBody Login loginbean) {
		

		String account = loginbean.getAccount();
		System.out.println("account = " + account);
		Integer memberId = loginRepo.findMemberIdByAccount(account);
		System.out.println("memberId = " + memberId);
		List<String[]> list = ordersResopository.findInfoByMemberId(memberId);

		
		System.out.println(list.toString());
		return list;
	}
	
	
	@PostMapping("/app/orderDetail")
	public List<String[]> orderDetail(@RequestBody OrderBean odb) {
		
		Integer orderId = odb.getOrderId();
		List<String[]> list = orderDetailsRepository.appFindByOrderId(orderId);
		return list;
	}
	
	@PostMapping("/app/insertOrderMaster")
	public String insertOrderMaster(@RequestBody OrderBean ob) {
	
		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		ob.setOrderDate(ts);
		ordersResopository.save(ob);
		System.out.println(ob.getOrderId().toString());
		return "已新增至訂單主檔"+"-"+ob.getOrderId().toString();
	}
	
	@PostMapping("/app/insertOrderDetail")
	public String insertOrderDetail(@RequestBody OrderItemBean oib) {
	
		System.out.println(oib);
	  
		orderDetailsRepository.save(oib);
		return "已新增至訂單detail檔";
	}


}

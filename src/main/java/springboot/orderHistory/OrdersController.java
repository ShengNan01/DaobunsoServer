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


}

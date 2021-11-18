package springboot.payment.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import springboot.ecpay.payment.integration.AllInOne;
import springboot.example.ExampleAllInOne;
import springboot.payment.entity.user;
import springboot.payment.repository.CustomerRepository;
import springboot.payment.repository.ProductRepository;

@Log4j2
//@RestController
@Controller
public class OrderController {
	private static AllInOne all;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	public ExampleAllInOne exampleAllInOne;

	
//	@PostMapping("/placeOrder2")
//	public user placeOrder(@RequestBody user request) {
////        user userA = new user();
//		return customerRepository.save(request);
////        userA.setOrderId(request.getOrderId());
//	}

	@SuppressWarnings("static-access")
	@PostMapping("/payment")
	public String PayPaymentPage(@RequestBody user userpayment ) {
		
		ExampleAllInOne.initial();

		UUID uid = UUID.randomUUID();//訂單編號
		String detailNo = "O" + uid.toString().replaceAll("-", "").substring(0, 6);
		userpayment.setDetailNo(detailNo);
		customerRepository.save(userpayment);
		Integer orderId = userpayment.getOrderId();
		String sum = userpayment.getSum();
		System.out.println( "結帳總金額:" + sum);
		log.info("跳轉綠界頁面");
	
		String paymentValue = exampleAllInOne.genAioCheckOutALL(sum, detailNo);// 獲得Html code
		log.info("123");
		user userBean = new user();
		userBean.setPayPayment(paymentValue); // 將html code塞到Bean中
//		model.addAttribute("paymentPage", userBean);// 回傳一個model到前端
		log.info("456");
		return "payPayment";
	}
	@GetMapping("/payment")
public String hello() {
		
		
		return "321";
	}
}

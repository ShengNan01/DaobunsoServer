package springboot.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.payment.dto.OrderRequest;
import springboot.payment.entity.user;
import springboot.payment.repository.CustomerRepository;
import springboot.payment.repository.ProductRepository;

@Controller
public class OrderContoller {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	@ResponseBody
	@PostMapping("/placeOrder2")
	public user placeOrder(@RequestBody user request) {
//        user userA = new user();
		return customerRepository.save(request);
//        userA.setOrderId(request.getOrderId());

	}

}

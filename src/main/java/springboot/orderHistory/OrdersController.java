package springboot.orderHistory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}

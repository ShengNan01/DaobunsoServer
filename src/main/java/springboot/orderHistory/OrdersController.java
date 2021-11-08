package springboot.orderHistory;

import java.util.List;

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
	public List<Object[]> read(@PathVariable Integer memberId) {
		List<Object[]> list = ordersResopository.findInfoByMemberId(memberId);
		return list;
	}
	
	@GetMapping("/orders/{memberId}/{orderId}")
	public List<Object[]> read(@PathVariable (required = false) Integer memberId, @PathVariable Integer orderId) {
		List<Object[]> list = orderDetailsRepository.findByOrderId(orderId);
		return list;
	}

}

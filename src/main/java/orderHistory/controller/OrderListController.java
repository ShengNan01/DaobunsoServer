package orderHistory.controller;

import org.springframework.stereotype.Controller;

import orderHistory.service.OrderService;

@Controller
public class OrderListController{
	
	OrderService orderService;

//	@Autowired
//	public OrderListController(OrderService orderService) {
//		this.orderService = orderService;
//	}
//
//	
//	@GetMapping("/orderList.do")
//	public String getOrderList (@RequestParam("memberId") Integer memberId,Model model) {
//		
//		System.out.println(memberId);
//		List<OrderBean> ob = orderService.findByMemberId(memberId);
//		model.addAttribute("OrderBean", ob);
//	
//		return "orderMain";
//	}
		
}

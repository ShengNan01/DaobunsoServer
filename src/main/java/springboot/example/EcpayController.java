//package springboot.example;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.extern.log4j.Log4j2;
//import springboot.ecpay.payment.integration.AllInOne;
//import springboot.ecpay.payment.integration.AllInOneBase;
//
//
//@Log4j2
//@RestController
//public class EcpayController {
//	
//	@Autowired
//	public AllInOne allInOne;
//	@Autowired
//	public AllInOneBase allInOneBase;
//	@Autowired
//	public ExampleAllInOne exampleAllInOne;
//	@Autowired
//	public PaymentRopository paymentRepository; 
//	
//	@GetMapping("/payment/{id}/{account}")
//	public String ecpaymentInfo ( Model model , @PathVariable("id") Integer id ,
//			@PathVariable("account") String account , @RequestParam("sum")  String value) { //還要放入Payment payment =>接值用
//		
//		
//		ExampleAllInOne.initial();
//		Integer val = Integer.parseInt(value); 
//		String paymentValue = exampleAllInOne.getAioChecOutAll(value , id);//獲得Html code
//		String totalPrice = payment.gettotalPrice();
//		System.out.println(paymentValue);
//		System.out.println("結帳總金額:" + totalPrice);
//		payment.setPayPayment(paymentValue);	//將html code塞到Bean中	
//		model.addAllAttributes("payment" , payment);//回傳一個model到前端
//		return "payingSuccess";
//		
//	}
//}

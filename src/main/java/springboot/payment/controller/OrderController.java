package springboot.payment.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import springboot.ecpay.payment.integration.AllInOne;
import springboot.example.ExampleAllInOne;
import springboot.payment.entity.user;
import springboot.payment.entity.userDetail;
import springboot.payment.repository.CustomerRepository;
import springboot.payment.repository.ProductRepository;

@Log4j2
@RestController
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
	@PostMapping("/payPayment")
//	public String  PayPaymentPage(@RequestBody user userpayment) {
	ResponseEntity<String> PayPaymentPage(@RequestBody user userpayment) {
		ExampleAllInOne.initial();
		UUID uid = UUID.randomUUID();// 訂單編號
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmm");
		Date current = new Date();
		String detailNo = "DBS" + sdFormat.format(current) + uid.toString().replaceAll("-", "").substring(0, 5);
		System.out.println(detailNo);
		userpayment.setDetailNo(detailNo);
		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		userpayment.setOrderDate(ts);
		customerRepository.save(userpayment);// 這邊之後要移到另一個方法
		List<userDetail> detail = userpayment.getUserDetails();

		StringBuilder orderItems = new StringBuilder();
//		StringJoiner orderItems = new StringJoiner(" ");
		for (int i = 0; i < detail.size(); i++) {
			if ((detail.get(i).getGarbageStartDate()) == null && (detail.get(i).getGarbageEndDate()) == null) {
//				orderItems.append(String.format("商品%", i+1))
				orderItems.append("商品 " + (i + 1)).append(" " + detail.get(i).getItemType())
						.append(" 數量: " + detail.get(i).getQuantity() + "#");
			} else if ((detail.get(i).getGarbageStartDate()) != null && (detail.get(i).getGarbageEndDate()) != null) {
				orderItems.append("商品 " + (i + 1)).append(" " + detail.get(i).getItemType())
						.append(" 數量: " + detail.get(i).getQuantity() + " ")
						.append("服務期限" + "(" + detail.get(i).getGarbageStartDate())
						.append("~" + detail.get(i).getGarbageEndDate() + ")" + "#");
			} else {
				orderItems.append("商品 " + (i + 1)).append(" " + detail.get(i).getItemType())
						.append(" 數量: " + detail.get(i).getQuantity() + " ")
						.append("服務期限" + "(" + detail.get(i).getGarbageStartDate())
						.append("~" + detail.get(i).getGarbageStartDate() + ")" + "#");
			}

		}
		log.info("分隔線");
		Integer orderId = userpayment.getOrderId();
		String sum = userpayment.getSum();
		System.out.println("結帳總金額:" + sum);
		log.info("跳轉綠界頁面");
		System.out.println(detail.toString());
		Map<String, String> map = new HashMap<>();
		String paymentValue = exampleAllInOne.genAioCheckOutALL(sum, detailNo, orderItems.toString());// 獲得Html code

		if (paymentValue != null) {
			map.put("paymentPage", paymentValue);
			return ResponseEntity.ok().body(paymentValue);
		} else {
			map.put("message", "交易失敗");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(paymentValue);
		}
	}
}

//	@PostMapping("/ecpayResponse")
//	public String ecpayResponse(@RequestBody String ecpayResponse, user userpayment) {
//		System.out.println(ecpayResponse);
//		String[] responses = ecpayResponse.split("&|=");
//		Map<String, String> responseInfo = new HashMap<>();
//		log.info(responses);
////			for(int i = 1; i<responses.length;i++) {
////				String[] returnKeyAndValue = responses[i].split("=");
//
////			}
////			log.info("ecpayResponse:" + responseInfo);
//		customerRepository.save(userpayment);
//		return "1|OK";
//	}

package test_springboot.Controller;

import org.springframework.web.bind.annotation.RestController;
import test_springboot.Grading;
import test_springboot.GradingRepo;
import test_springboot.Grading;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Grading_Controller {
	@Autowired
	private GradingRepo gradingRepo;
	MultiValueMap<String, Grading> fMultiValueMap = new LinkedMultiValueMap<>();
	
	@PostMapping("/grading")
	public Grading postG(@RequestBody Grading g) {
		fMultiValueMap.add(g.getUser_account(), g);
		System.out.println(fMultiValueMap);
		gradingRepo.save(g);
		return g;
	}
	@GetMapping("/grading")
	public void getG(
			@RequestParam("uaccount") String uaccount) {
		System.out.println(uaccount);
		gradingRepo.findall(uaccount);
	}
	
//	@PutMapping("/feedback")
//	public String putF(
//			@RequestParam("oid") String oid,
//			@RequestBody Feedback fe) {
//		System.out.println(oid);
//		if(fMultiValueMap.containsValue(oid)) {
//		}
//		return "add";
//	}
//	@DeleteMapping("/feedback")
//	public String deleteF() {
//		return "delete";
//	}
//	@GetMapping(value = "/verify")
//	public void getverify( 
//			@RequestParam("uid") String uid,
//			@RequestParam("email") String email
//			) {
//		System.out.println(uid);
//		System.out.println(email);
//	}
	

	

//	@PutMapping("/feedback")
//	public String putF(@RequestBody Feedback fe) {
//		fe.save();
//		return "add";
//	}
//	@DeleteMapping("/feedback")
//	public String deleteF() {
//
//		return "delete";
//	}
//	
//	RequestMapping("/feedback/submit{x}")
//	public Holo getFeedback(@PathVariable("x") String x) {
//		System.out.println(x);
//		Holo neolHolo = new Holo("Neol",22,165.0,53.0,"....!","www");
//		return neolHolo;
//	}
}

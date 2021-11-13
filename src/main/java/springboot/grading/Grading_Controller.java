package springboot.grading;

import org.springframework.web.bind.annotation.RestController;

import springboot.login.LoginRepo;

import java.io.Console;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Grading_Controller {
	@Autowired
	GradingRepo gradingRepo;
	@Autowired
	LoginRepo loginRepo;
//	MultiValueMap<String, Grading> fMultiValueMap = new LinkedMultiValueMap<>();
	
	@GetMapping("/gradings")
	public List<Optional<Grading>> getGradings() {
		List<Optional<Grading>> gradings = new ArrayList<Optional<Grading>>();
		while(gradings.size()<3){
			Integer randomidInteger = (Integer) (int) (1 + gradingRepo.findLastid() * Math.random());		
			if(gradingRepo.existsById(randomidInteger)) {
				gradings.add(gradingRepo.findById(randomidInteger));
//				System.out.println("gradingRepo.existsById(selectidInteger) = "+ randomidInteger);
			}else {
//				System.err.println("Error!! gradingRepo.existsById(selectidInteger) = "+ randomidInteger);
			}
		}
//		System.out.println(gradings);
		return gradings;
	}
	@PostMapping("/grading")
	public Boolean postG(@RequestBody Grading g,@RequestParam String email) {
		if(email.equals(loginRepo.findEmailByAccount(g.getAccount()))) {
			g.setDate(new Timestamp(System.currentTimeMillis()).toString());
			gradingRepo.save(g);
			return true;
		}else {
			return false;
		}
	}
	@GetMapping("/grading")
	public List<Grading> getG(@RequestParam("uaccount") String uaccount) {
		return gradingRepo.findByAccount(uaccount);
	}
	@DeleteMapping("/grading")
	public String deleteG(@RequestParam("objectid") Integer objectid) {
		gradingRepo.deleteById(objectid);
		return "刪除評論成功!";
	}
	@PutMapping("/grading")
	public String putG(@RequestBody Grading g,@RequestParam String email) {
		if(email.equals(loginRepo.findEmailByAccount(g.getAccount()))) {
			g.setDate(new Timestamp(System.currentTimeMillis()).toString());
		gradingRepo.updateGradingById(g.getObjectid());
		System.err.println(g.getObjectid());
		return "編輯成功!\t"+"編輯時間為:"+g.getDate();
		}else {
			return "False~";
		}
	}
	
	@PostMapping("/app/grading")
	public String appPostG(@RequestBody Grading g) {
		g.setDate(new Timestamp(System.currentTimeMillis()).toString());
		gradingRepo.save(g);
		return "新增評論成功";
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
//			@RequestParam("email") String email) {
//		System.out.println(uid);
//		System.out.println(email);
//	}
//	
//	RequestMapping("/feedback/submit{x}")
//	public Holo getFeedback(@PathVariable("x") String x) {
//		System.out.println(x);
//		return neolHolo;
//	}
}

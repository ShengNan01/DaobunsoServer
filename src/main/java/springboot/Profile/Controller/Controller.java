//package springboot.Profile.Controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import springboot.Profile.Bean.MemberBean;
//import springboot.Profile.Service.Service;
//
//@RestController
//public class Controller {
//	@Autowired
//	Service service;
//	@PostMapping("/profile")
//	public Optional<MemberBean> getMemberProfile(@RequestBody MemberBean member) {
//	Optional<MemberBean> bean = Optional.of(service.findById(member.getMember_Id()).orElse(null));
//		return bean;
//	}
//}

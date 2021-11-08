package springboot.Profile.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.register.MemberBean;
import springboot.register.MemberRepository;



@RestController
public class Controller {
	@Autowired
	private MemberRepository memberRepository;
	@PostMapping("/profiles")
	public Optional<MemberBean> getMemberProfile(@RequestBody MemberBean member) {
		Optional<MemberBean> bean = Optional.of(memberRepository.findById(member.getMember_Id()).orElse(null));
		return bean;
	}
}

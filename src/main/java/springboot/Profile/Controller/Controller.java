package springboot.Profile.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.register.MemberBean;
import springboot.register.MemberRepository;



@RestController
public class Controller {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private JavaMailSender mailSender;
	@PostMapping("/profiles")
	public Optional<MemberBean> getMemberProfile(@RequestBody MemberBean member) {
		Optional<MemberBean> bean = Optional.of(memberRepository.findById(member.getMember_Id()).orElse(null));
		return bean;
	}
	@GetMapping("/email")
	public void sendSimpleMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("grfmbiu324568@gmail.com");
		message.setTo("bb33064980@gmail.com");
		message.setSubject("主旨：Hello");
		message.setText("內容：這是一封測試信件，恭喜您成功發送了唷");
		mailSender.send(message);
	}
}

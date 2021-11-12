package springboot.Profile.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import springboot.register.MemberBean;
import springboot.register.MemberRepository;
import springboot.util.GlobalService;
import springboot.util.changePasswordMailUtils;

@Log4j2
@RestController
public class ProfilesController {

	@Autowired
	public changePasswordMailUtils changePasswordMailUtils;

	@Autowired
	private MemberRepository memberRepository;

	@PostMapping("/profiles")
	public Optional<MemberBean> getMemberProfile(@RequestBody MemberBean member) {
		Optional<MemberBean> bean = Optional.of(memberRepository.findById(member.getMemberId()).orElse(null));
		return bean;
	}

	@PostMapping("/Change_pswd")
	public String changePswd(@RequestBody  MemberBean member) {
		String  password = member.getPassword();
		String  newPassword = member.getNewPassword();
		Integer memberId = member.getMemberId();
		// 解密
		String EncryptPassword = memberRepository.findPasswordById(memberId);
		String decryptPassword = GlobalService.decryptString(GlobalService.KEY, EncryptPassword);
		// 比對密碼
		System.out.println("輸入的新密碼 = " + newPassword + "    " + 
						   "輸入的舊密碼 = " + password + "    " + 
						   "比對的原密碼 = " + decryptPassword);
		if (password.equals(decryptPassword)) {
			System.out.println("密碼比對正確");
			// 更新密碼
			String enPswd = GlobalService.encryptString(newPassword);
			memberRepository.updateMemberPassword(enPswd, memberId);
			System.out.println("會員ID= " + memberId + "   " + "會員密碼= " + newPassword);
			return "Success";
		} else {
			return "Fail";
		}
	}

	@PostMapping("/verifyEmail")
	public String verifyEmail(@RequestBody MemberBean member) {
		Integer memberId = member.getMemberId();
		String  email = member.getEmail();
		System.out.println("會員id:" + memberId + "   " + "會員email: " + email );
//		MemberBean mbEmail = memberRepository.findEmailById(memberId)
		String memberEmail = memberRepository.findEmailById(member.getMemberId());
		System.out.println(memberEmail);
		Boolean existEmail = memberRepository.existsByEmail(memberEmail);
		System.out.println(existEmail);

		if (existEmail && memberEmail.equals(member.getEmail())) {
			log.info("寄送驗證信");
			changePasswordMailUtils.sendEmail(member, member.getEmail());
			return "Success";
		} else {
			return "Fail";
		}

	}
}

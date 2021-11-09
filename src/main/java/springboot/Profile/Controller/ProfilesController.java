package springboot.Profile.Controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.util.GlobalService;
import springboot.register.MemberBean;
import springboot.register.MemberRepository;
import util.MailUtils;

@RestController
public class ProfilesController {
	@Autowired
	private MemberRepository memberRepository;

	@PostMapping("/profiles")
	public Optional<MemberBean> getMemberProfile(@RequestBody MemberBean member) {
		Optional<MemberBean> bean = Optional.of(memberRepository.findById(member.getMember_Id()).orElse(null));
		return bean;
	}
//
//	@PostMapping("/change_password/{memberId}")
//	public String changePswd(@RequestBody @Valid MemberBean member) {
//		String oldPassword = member.getPassword();
//		String Password = member.getNewPassword();
//		Integer member_Id = member.getMember_Id();
//		// 解密
//		String EncryptPassword = memberRepository.findById(member_Id).getPassword();
//		String decryptPassword = GlobalService.decryptString(GlobalService.KEY, EncryptPassword);
//		// 比對密碼
//		System.out.println("輸入的新密碼 = " + member.getNewPassword() + "/n" + "輸入的舊密碼 = " + member.getPassword() + "/n"
//				+ "比對的原密碼 = " + decryptPassword);
//		if (oldPassword.equals(decryptPassword)) {
//			System.out.println("密碼比對正確");
//			// 更新密碼
//			String enPswd = GlobalService.encryptString(Password);
//			memberRepository.updateMemberPassword(enPswd, member_Id);
//			System.out.println("會員ID= " + member_Id + "   " + "會員密碼= " + Password);
//			return "Success";
//		} else {
//			return "fail";
//		}
//	}
//
//	@PostMapping("/verify_email/{memberId}/{email}")
//	public String verifyEmail(@RequestBody @Valid MemberBean member) {
////		 public boolean verifyEmail (@RequestBody @Valid String email) {
//		String changePasswordEmail = member.getEmail();
//		Integer member_Id = member.getMember_Id();
//		System.out.println("會員輸入的信箱為:" + changePasswordEmail);
//		if (memberRepository.existsByMemberEmail(changePasswordEmail)
//				&& memberRepository.findInfoById(member_Id).getEmail().equals(member.getEmail())) {
//			String emailMsg = "請點擊<a href='http://localhost:8080/Daobunso_Project/change_password.html"
//					+ "'>點擊修改密碼</a>";
//			System.out.println("正在發送郵件...");
//			new Thread() {
//				@Override
//				public void run() {
//					try {
//						// 發送郵件
//						try {
//							MailUtils.sendMail(member.getEmail(), emailMsg);
//						} catch (UnsupportedEncodingException e) {
//							e.printStackTrace();
//						}
//					} catch (AddressException e) {
//						e.printStackTrace();
//					} catch (MessagingException e) {
//						e.printStackTrace();
//					} catch (GeneralSecurityException e) {
//						e.printStackTrace();
//					}
//					System.out.println("發送郵件成功!");
//				}
//			}.start();
//			return "Success";
//		} else {
//			return "Fail";
//		}
//
//	}
}

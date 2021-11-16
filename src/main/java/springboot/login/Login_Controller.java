package springboot.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.orderHistory.OrderBean;
import lombok.extern.log4j.Log4j2;
import springboot.register.MemberBean;
import springboot.register.MemberRepository;
import springboot.util.GlobalService;
import springboot.util.forgetPasswordMailUtils;

@Log4j2
@RestController
public class Login_Controller {

	@Autowired
	LoginRepo loginRepo;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	forgetPasswordMailUtils forgetPasswordMailUtils;

	@SuppressWarnings("unused")
	@PostMapping("/app/logincheck")
	public String clientLogin(@RequestBody Login loginBean) {
//		System.out.println(loginBean.toString());
		String account = loginBean.getAccount();
		String password = loginBean.getPassword();
//		System.out.println("Account:"+account +"\tPassword:"+ decryptPassword);
//		System.out.println("Account:"+loginBean.getAccount() +"\tPassword:"+ loginBean.getPassword());
		if(loginBean!=null) {
			
			if(loginRepo.existsByAccount(loginBean.getAccount())) { //核對確認有這個帳號
				String decryptPassword = GlobalService.decryptString(GlobalService.KEY
						,loginRepo.findPasswordByMemberAccount(loginBean.getAccount()));
				String memberId = loginRepo.findMemberIdByAccount(loginBean.getAccount()).toString();
				
//				System.out.println(loginRepo.findLoginByAccount(account));
				// 解密後密碼與使用者輸入的密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)) {
					
					return "OK"+"-"+memberId;				
				}
				// 如果密碼不正確
				else {
					return "NG";
				}
			}
			// 如果沒有這個帳號
			else {

				return "NG";
			}

		}
		// 如果前端傳來的loginBean是null
		else {
			return "NG";
		}

	}

//	@RequestBody MemberBean member
	@SuppressWarnings("unused")
	@PostMapping("/app/forgetPw")
	public String forgetPw() {

//		String account = member.getAccount();
//		String email = member.getEmail();
////	
//		if(member!=null) {
//			
//			if(loginRepo.existsByAccount(account)) { //核對確認有這個帳號
//				
//				//確認為與註冊時相同email
//				MemberBean mb = memberRepository.findByAccount(account);
//				if(mb.getEmail().equals(email)) {
//					//寄信				
//					return "成功寄出信件";
//				}
//				else {
//					//
//					return "email與註冊時不一樣";
//				}
//	         }
//			else {
//				return "無此帳號";
//			}
//        }
//		else {
//			return "memberNull";
//		}

		return "ok";

	}

	@SuppressWarnings("unused")
	@PostMapping("/app/changPw")
	public String changPw(@RequestBody MemberBean member) {

		String password = member.getPassword();
		String account = member.getAccount();

		if (member != null) {

			String enPswd = GlobalService.encryptString(password);

			if (loginRepo.existsByAccount(account)) { // 核對確認有這個帳號

				// 更改密碼
				Integer i = loginRepo.UpdatePasswordByAccount(enPswd, account);

				if (i == 1) {
					return "更改密碼成功";
				} else {
					return "NG";
				}
			} else {
				return "NG";
			}
		} else {
			return "memberNull";
		}
	}

	@PostMapping("/logincheck")
	public Boolean webLogin(@RequestParam("rememberMe") Boolean rememberMe, @RequestBody Login login,
			HttpServletResponse response) {
		if (login != null) {
			String account = login.getAccount();
			String password = login.getPassword();
			if (loginRepo.existsByAccount(login.getAccount())) { // 核對確認有這個帳號
				String decryptPassword = GlobalService.decryptString(GlobalService.KEY,
						loginRepo.findPasswordByMemberAccount(login.getAccount()));
				System.out
						.println("Account:" + account + "\tPassword:" + decryptPassword + "\tRememberMe:" + rememberMe);
//				System.out.println(loginRepo.findLoginByAccount(account));
				// 前端密碼與加密前後的資料庫密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)
						|| password.equals(loginRepo.findPasswordByMemberAccount(login.getAccount()))) {

					Login loginc = loginRepo.findLoginByAccount(account);
					Cookie cookieLogin = new Cookie("LoginOK", "這樣才酷!");
					Cookie cookieId = new Cookie("id", loginc.getId().toString());
					Cookie cookieName = new Cookie("name", loginc.getName());
					Cookie cookieAccount = new Cookie("account", loginc.getAccount());
					Cookie cookieEmail = new Cookie("email", loginc.getEmail());
					Cookie cookieVerification = new Cookie("verification", loginc.getVerification().toString().trim());
					cookieLogin.setMaxAge(7 * 24 * 60 * 60);
					cookieId.setMaxAge(7 * 24 * 60 * 60);
					cookieName.setMaxAge(7 * 24 * 60 * 60);
					cookieAccount.setMaxAge(7 * 24 * 60 * 60);
					cookieEmail.setMaxAge(7 * 24 * 60 * 60);
					cookieVerification.setMaxAge(7 * 24 * 60 * 60);
					cookieLogin.setPath("/");
					cookieId.setPath("/");
					cookieName.setPath("/");
					cookieAccount.setPath("/");
					cookieEmail.setPath("/");
					cookieVerification.setPath("/");
					response.addCookie(cookieLogin);
					response.addCookie(cookieId);
					response.addCookie(cookieName);
					response.addCookie(cookieAccount);
					response.addCookie(cookieEmail);
					response.addCookie(cookieVerification);

					if (rememberMe) {
						Cookie cookiePassword = new Cookie("password", loginc.getPassword());
						cookiePassword.setMaxAge(7 * 24 * 60 * 60);
						cookiePassword.setPath("/");
						response.addCookie(cookiePassword);
					}
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	@PostMapping("/forgetPswdEmail")
	public Map<String, Object> forgetPswdEmail(@RequestBody MemberBean member) {
		Map<String, Object> info = new HashMap<>();
		String account = member.getAccount();
		String email = member.getEmail();
		System.out.println("輸入的帳號:" + account + "\t" + "輸入的信箱:" + email);
		Boolean existsAccount = loginRepo.existsByAccount(account);
		System.out.println(existsAccount);
		Boolean existsEmail = memberRepository.existsByEmail(email);
		System.out.println(existsEmail);
		Boolean exists = existsAccount && existsEmail;
		if (exists) {
			info.put("checkMemberInfo", "ok");
			info.put("memberAccount", account);
			info.put("memberEmail", email);
			log.info("寄送忘記密碼驗證信");
			Login loginBean = loginRepo.findLoginByAccount(account);
			System.out.println(loginBean);
			if (exists && account.equals(loginBean.getAccount()) && email.equals(loginBean.getEmail())) {
				forgetPasswordMailUtils.sendEmail(member, email);
				log.info("寄送驗證信成功");
				info.put("sending", "Success");
			} else {
				log.info("寄送驗證信失敗");
				info.put("sending", "fail");
			}
			log.info(info);

		} else if (!exists) {
			log.info("===使用者傳送的資料錯誤=== or ===前端js沒有match後端===");
			info.put("checkmemberinfo", "notok");
			log.info(info);
		}
		return info;
	}
	
	@PostMapping("/forgetPswd")
	public String forgetPswd(@RequestBody MemberBean member) {
		String account = member.getAccount();
		String email = member.getEmail();
		String newPassword = member.getNewPassword();
		System.out.println("會員帳號 =" + account + "\t" +"會員信箱 =" +email + "\t" +"會員輸入的新密碼 =" + newPassword);
		Boolean exists = memberRepository.existsByEmail(email) && loginRepo.existsByAccount(account);
		log.info("輸入資料是否存在於資料庫:" + exists);
		Login loginBean = loginRepo.findLoginByAccount(account);
		if (exists && account.equals(loginBean.getAccount()) && email.equals(loginBean.getEmail())) {
			String enPswd = GlobalService.encryptString(newPassword);
			memberRepository.updateMemberForgetPassword(enPswd, account);
			log.info("更新密碼成功");
			return "Success";
		} else {
			return "Fail";
		}
	}
}

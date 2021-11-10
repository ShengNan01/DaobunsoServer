package springboot.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.register.MemberBean;
import springboot.register.MemberRepository;
import springboot.util.GlobalService;


@RestController
 public class Login_Controller {

	@Autowired
	LoginRepo loginRepo;
	
	@Autowired
    private MemberRepository memberRepository;
	

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

		if(member!=null) {
			
			String enPswd = GlobalService.encryptString(password);
			
			if(loginRepo.existsByAccount(account)) { //核對確認有這個帳號
							
				//更改密碼
			    Integer i = loginRepo.UpdatePasswordByAccount(enPswd,account);
			    
			    if(i==1) {
			    return "更改密碼成功";	
			    }
			    else {
					return "NG";
				}
	         }
			else {
				return "NG";
			}
        }
		else {
			return "memberNull";
		}
	}
	@PostMapping("/web/logincheck")
	public Boolean webLogin(@RequestParam("rememberMe") Boolean rememberMe, @RequestBody Login login, HttpServletResponse response) {
		if (login != null) {
			String account = login.getAccount();
			String password = login.getPassword();
			if (loginRepo.existsByAccount(login.getAccount())) { //核對確認有這個帳號
				String decryptPassword = GlobalService.decryptString(GlobalService.KEY
						, loginRepo.findPasswordByMemberAccount(login.getAccount()));
				System.out.println("Account:" + account + "\tPassword:" + decryptPassword + "\tRememberMe:" + rememberMe);
//				System.out.println(loginRepo.findLoginByAccount(account));
				// 前端密碼與加密前後的資料庫密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)
						|| password.equals(loginRepo.findPasswordByMemberAccount(login.getAccount()))) {
					
					Login loginc = loginRepo.findLoginByAccount(account);
					Cookie cookieLogin = new Cookie("LoginOK","這樣才酷!");
					Cookie cookieId = new Cookie("id", loginc.getId().toString());
					Cookie cookieName = new Cookie("name", loginc.getName());
					Cookie cookieAccount = new Cookie("account", loginc.getAccount());
					Cookie cookieEmail = new Cookie("email", loginc.getEmail());
					cookieLogin.setMaxAge(7 * 24 * 60 * 60);
					cookieId.setMaxAge(7 * 24 * 60 * 60);
					cookieName.setMaxAge(7 * 24 * 60 * 60);
					cookieAccount.setMaxAge(7 * 24 * 60 * 60);
					cookieEmail.setMaxAge(7 * 24 * 60 * 60);
					cookieLogin.setPath("/");
					cookieId.setPath("/");
					cookieName.setPath("/");
					cookieAccount.setPath("/");
					cookieEmail.setPath("/");
					response.addCookie(cookieLogin);
					response.addCookie(cookieId);
					response.addCookie(cookieName);
					response.addCookie(cookieAccount);
					response.addCookie(cookieEmail);

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
	
}

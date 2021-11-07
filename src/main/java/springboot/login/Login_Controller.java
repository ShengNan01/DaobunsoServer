package springboot.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import util.GlobalService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
public class Login_Controller {

	@Autowired
	LoginRepo loginRepo;

	@GetMapping("/testt")
	public void testt() {
		System.out.println(GlobalService.decryptString(GlobalService.KEY
				, loginRepo.findPasswordByMemberAccount("hsi")));
	}

	@PostMapping("/web/logincheck")
	public String webLogin(@RequestParam("rememberMe") Boolean rememberMe, @RequestBody Login login, HttpServletResponse response) {
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
					if (rememberMe) {
						Login loginc = loginRepo.findLoginByAccount(account);
						Cookie cookieName = new Cookie("name", loginc.getName());
						Cookie cookieAccount = new Cookie("account", loginc.getAccount());
						Cookie cookiePassword = new Cookie("password", loginc.getPassword());
						Cookie cookieEmail = new Cookie("email", loginc.getEmail());
						cookieName.setMaxAge(7 * 24 * 60 * 60);
						cookieAccount.setMaxAge(7 * 24 * 60 * 60);
						cookiePassword.setMaxAge(7 * 24 * 60 * 60);
						cookieEmail.setMaxAge(7 * 24 * 60 * 60);
						response.addCookie(cookieName);
						response.addCookie(cookieAccount);
						response.addCookie(cookiePassword);
						response.addCookie(cookieEmail);
					}
					return "這樣才COOL~!";
				}
			}
		}
		return "這樣不夠COOL..";
	}
}

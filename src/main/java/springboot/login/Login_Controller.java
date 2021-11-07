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
	public void testt(){
		System.out.println(GlobalService.decryptString(GlobalService.KEY
				,loginRepo.findPasswordByMemberAccount("hsi")));
	}

	@PostMapping("/logincheck")
	public String clientLogin(@RequestParam("rememberMe") Boolean rememberMe, @RequestBody Login loginBean, HttpServletResponse response) {
		if(loginBean!=null) {
			String account = loginBean.getAccount();
			String password = loginBean.getPassword();
		
			if(loginRepo.existsByAccount(loginBean.getAccount())) { //核對確認有這個帳號
				String decryptPassword = GlobalService.decryptString(GlobalService.KEY
						,loginRepo.findPasswordByMemberAccount(loginBean.getAccount()));
				System.out.println("Account:"+account +"\tPassword:"+ decryptPassword+"\tRememberMe:"+rememberMe);
				System.out.println(loginRepo.findLoginByAccount(account));
			// 解密後密碼與使用者輸入的密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)) {
					if (rememberMe){
						Cookie cookie = new Cookie("clogin","這樣才~cooooooookie!");
						cookie.setDomain("localhost");
						response.addCookie(cookie);
					}
					return "OK";				
				}
				// 如果密碼不正確
				else {
					return "NG";
				}
		 }
			//如果沒有這個帳號
		else {

			return "NG";
		}

	}
		//如果前端傳來的loginBean是null
		else {
			return "NG";
		}

	}
	
}

package springboot.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import util.GlobalService;


@RestController
public class Login_Controller {
	
	String decryptPassword;
	String EncryptPassword;
	Login loginBean;
	
	@Autowired
	LoginRepo loginRepo;
	
	@PostMapping("/logincheck")
	public String clientLogin(@RequestBody Login loginBean) {
		
		if(loginBean!=null) {
			String account = loginBean.getAccount();
			String password = loginBean.getPassword();
		
			if(loginRepo.existsByMemberAccount(account)) { //核對確認有這個帳號
				EncryptPassword = loginRepo.findPasswordByMemberAccount(account);
				decryptPassword = GlobalService.decryptString(GlobalService.KEY, EncryptPassword);

			System.out.println(account + decryptPassword);

			// 解密後密碼與使用者輸入的密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)) {
					loginBean = loginRepo.findInfoByMemberAccount(account);
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

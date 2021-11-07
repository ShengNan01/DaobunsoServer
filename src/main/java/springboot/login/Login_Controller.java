package springboot.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import util.GlobalService;



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
				
//				System.out.println(loginRepo.findLoginByAccount(account));
			// 解密後密碼與使用者輸入的密碼比對。如果密碼一樣，就成功豋入
				if (password.equals(decryptPassword)) {
					
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

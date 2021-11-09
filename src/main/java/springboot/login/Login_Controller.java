package springboot.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.register.MemberBean;
import springboot.register.MemberRepository;
import util.GlobalService;



@RestController
public class Login_Controller {

	@Autowired
	LoginRepo loginRepo;
	
	@Autowired
    private MemberRepository memberRepository;
	


	@GetMapping("/testt")
	public void testt(){
		System.out.println(GlobalService.decryptString(GlobalService.KEY
				,loginRepo.findPasswordByMemberAccount("hsi")));
	}

	@SuppressWarnings("unused")
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
	
}

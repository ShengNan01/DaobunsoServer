package springboot.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import springboot.register.MemberBean;
import springboot.register.MemberRepository;
import springboot.util.GlobalService;



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
	
}

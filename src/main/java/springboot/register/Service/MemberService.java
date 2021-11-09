package springboot.register.Service;

import springboot.register.MemberBean;

public interface MemberService {

	MemberBean findByAccount(String account);
	
}

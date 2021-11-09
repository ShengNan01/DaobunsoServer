package springboot.register.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import springboot.register.MemberBean;
import springboot.register.MemberRepository;
import springboot.register.Service.MemberService;

public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberpopository;
	@Override
	public MemberBean findByAccount(String account) {
		return memberpopository.findByAccount(account);
	}
}

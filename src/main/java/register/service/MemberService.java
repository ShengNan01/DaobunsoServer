package register.service;

import java.util.List;

import register.model.MemberBean;


public interface MemberService {

	boolean existsByMemberAccount(String account);

	void save(MemberBean memberBean);

	List<MemberBean> findAll();

	MemberBean findById(Integer memberId);

	void delete(Integer memberId);

	void update(MemberBean memberBean);
	
	boolean existsByMemberEmail(String email);
}
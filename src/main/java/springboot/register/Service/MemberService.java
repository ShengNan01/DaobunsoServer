package springboot.register.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.register.MemberBean;

public interface MemberService extends JpaRepository<MemberBean, Integer>{

	MemberBean findByAccount(String account);
}

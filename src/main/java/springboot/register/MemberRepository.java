package springboot.register;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberBean, Integer> {

    MemberBean findByAccount(String account);
    
}

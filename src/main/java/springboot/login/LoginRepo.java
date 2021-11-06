package springboot.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Login,Integer> {
	
	// 由使用者輸入的account找password
	@Query(nativeQuery = true, value="")
	String findPasswordByMemberAccount(String account);
	
	
	// 確認有無此帳號
	boolean existsByMemberAccount(String account);
	
	
	// 由帳號找login的bean
	Login findInfoByMemberAccount(String account);
	
	
	
}

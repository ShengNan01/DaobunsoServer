package springboot.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Login,Integer> {
	
	// 由使用者輸入的account找password
	@Query(nativeQuery = true, value="SELECT password FROM daobunso.member WHERE Account= :account")
	String findPasswordByMemberAccount(String account);
	
	
	// 確認有無此帳號
	Boolean existsByAccount(String account);
	
	
	// 由帳號找login的bean
	Login findLoginByAccount(String account);
	
	
	
}

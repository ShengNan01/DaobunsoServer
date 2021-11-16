package springboot.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {

	// 由使用者輸入的account找password
	@Query(nativeQuery = true, value = "SELECT Password FROM daobunso.member WHERE Account= :account")
	String findPasswordByMemberAccount(String account);

	@Query(nativeQuery = true, value = "SELECT Email FROM daobunso.member WHERE Account= :account")
	String findEmailByAccount(String account);

	// 確認有無此帳號
	Boolean existsByAccount(String account);

	// 由帳號找login的bean
	Login findLoginByAccount(String account);

	// APP更改密碼
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE daobunso.member SET Password = :password  WHERE Account= :account")
	Integer UpdatePasswordByAccount(@Param(value = "password") String password,
			@Param(value = "account") String account);

	// APP由acount找到memberId
	@Query(nativeQuery = true, value = "SELECT Member_Id FROM daobunso.member WHERE Account= :account")
	Integer findMemberIdByAccount(String account);

}

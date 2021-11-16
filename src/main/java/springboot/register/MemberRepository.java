package springboot.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<MemberBean, Integer> {

	MemberBean findByAccount(String account);

	MemberBean findByEmail(String email);

	@Query(value = "SELECT Password FROM member WHERE Member_Id = ?1 ", nativeQuery = true)
	String findPasswordById(Integer memberId);

	@Query(value = "SELECT Email FROM member WHERE Member_Id = ?1 ", nativeQuery = true)
	String findEmailById(Integer memberId);

//    boolean existByMemberEmail(String email);
	boolean existsByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "UPDATE member SET Password= ?1 WHERE Member_Id= ?2", nativeQuery = true)
	void updateMemberPassword(String password, Integer memberId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE member SET Password= ?1 WHERE Account= ?2", nativeQuery = true)
	void updateMemberForgetPassword(String password, String account);

}

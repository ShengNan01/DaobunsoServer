package springboot.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface MemberRepository extends JpaRepository<MemberBean, Integer> {

	
    MemberBean findByAccount(String account);
//    
//    MemberBean findInfoById(Integer member_Id);
//    
//    
//    boolean existsByMemberEmail(String email);
//    
//    @Modifying
//    @Query(value = "UPDATE member SET Password= ?1 WHERE Member_Id= ?2" ,nativeQuery = true)
//    void updateMemberPassword(String password , Integer member_Id);
//    
//    @Modifying
//    @Query(value = "UPDATE member SET Password= ?1 WHERE Member_Id= ?2" ,nativeQuery = true)
//    void updateMemberForgetPassword(String password , String account);
//    
}

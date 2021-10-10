package register.dao;

import java.util.List;

import register.model.MemberBean;

public interface MemberDao {
	
 boolean existsByMemberName(String name);
 
 void save(MemberBean memberBean);
 
 List<MemberBean> findAll();
 
 MemberBean findById(Integer memberId);
 
 void delete(Integer memberId);
 
 void update(MemberBean memberBean);
}

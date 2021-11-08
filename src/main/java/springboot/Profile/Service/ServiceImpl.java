package springboot.Profile.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.Profile.Bean.MemberBean;
import springboot.Profile.repository.Repo;
@Component
public class ServiceImpl implements Service {
	@Autowired
	Repo repo;
	@Override
	public Optional<MemberBean> findById(Integer memberId) {
		return repo.findById(memberId);
	}

}

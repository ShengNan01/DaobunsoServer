package springboot.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Login,Integer> {

}

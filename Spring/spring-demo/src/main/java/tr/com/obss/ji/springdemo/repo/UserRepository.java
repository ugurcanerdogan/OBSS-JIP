package tr.com.obss.ji.springdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.obss.ji.springdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

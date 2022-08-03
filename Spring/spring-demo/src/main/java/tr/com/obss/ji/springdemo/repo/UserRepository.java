package tr.com.obss.ji.springdemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tr.com.obss.ji.springdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	List<User> findByUsernameStartsWithAndActiveTrueOrderByCreateDateDesc(String username);

	List<User> findByRoles_NameIn(List<String> roles);

	@Query(value = "select u from User u where u.id = :id")
	Optional<User> getByIdHQL(long id);

	@Query(value = "select * from Users where id = :id", nativeQuery = true)
	Optional<User> getByIdNative(long id);

}

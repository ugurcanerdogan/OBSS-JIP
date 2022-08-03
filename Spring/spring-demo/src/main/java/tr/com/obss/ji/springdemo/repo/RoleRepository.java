package tr.com.obss.ji.springdemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.obss.ji.springdemo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);

	boolean existsByName(String name);

}

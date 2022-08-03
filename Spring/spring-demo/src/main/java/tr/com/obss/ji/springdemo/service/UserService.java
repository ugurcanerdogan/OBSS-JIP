package tr.com.obss.ji.springdemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tr.com.obss.ji.springdemo.cache.UserCache;
import tr.com.obss.ji.springdemo.cache.UserCachePrototype;
import tr.com.obss.ji.springdemo.model.User;
import tr.com.obss.ji.springdemo.model.dto.UserDTO;
import tr.com.obss.ji.springdemo.model.dto.UserUpdateDTO;
import tr.com.obss.ji.springdemo.repo.UserDAO;
import tr.com.obss.ji.springdemo.repo.UserRepository;

@Service
public class UserService {

	private final ApplicationContext applicationContext;

	private final UserRepository userRepository;

	private final UserDAO userDAO;

	private final UserCache userCache;

	// @Qualifier("userCacheSingleton") gelebilir userCache argüman öncesine ama, @primary
	// tercih ettim.
	public UserService(ApplicationContext applicationContext, UserCache userCache, UserRepository userRepository,
			UserDAO userDAO) {
		this.applicationContext = applicationContext;
		this.userCache = userCache;
		this.userRepository = userRepository;
		this.userDAO = userDAO;
	}

	public User save(UserDTO userDTO) {

		var user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findByUsername(String username) {
		var userOpt = userRepository.findByUsername(username);
		return userOpt.orElseThrow(() -> {
			throw new IllegalArgumentException("User not found");
		});
	}

	public List<User> findAllByUsername(String username) {
		return userRepository.findByUsernameStartsWithAndActiveTrueOrderByCreateDateDesc(username);
	}

	public User findById(long id) {
		var userOpt = userRepository.findById(id);
		return userOpt.orElseThrow(() -> {
			throw new IllegalArgumentException("User not found");
		});
	}

	public User findByIdWithHQL(long id) {
		var userOpt = userRepository.getByIdHQL(id);
		return userOpt.orElseThrow(() -> {
			throw new IllegalArgumentException("User not found");
		});
	}

	public User findByIdWithNativeSQL(long id) {
		var userOpt = userRepository.getByIdNative(id);
		return userOpt.orElseThrow(() -> {
			throw new IllegalArgumentException("User not found");
		});
	}

	public Page<User> findAllWithJpaPagination(int pageNumber, int pageSize) {
		var paged = PageRequest.of(pageNumber, pageSize);
		return userRepository.findAll(paged);
	}

	public List<User> findAllWithDaoPagination(int pageNumber, int pageSize) {
		return userDAO.get(pageNumber, pageSize);
	}

	public User update(long id, UserUpdateDTO userUpdateDTO) {
		var user = this.findById(id);
		user.setPassword(userUpdateDTO.getPassword());
		return userRepository.save(user);
	}

	public User remove(long id) {
		var user = this.findById(id);
		user.setActive(!user.isActive());
		return userRepository.save(user);
	}

	public Map<String, Map> saveCache(UserDTO userDTO) {
		// singleton içindeki prototype da singleton gibi çalışır. o yüzden, ayrıca
		// contexten çek prototype'ı!

		var userCachePrototype = applicationContext.getBean(UserCachePrototype.class);
		var userCacheSingleton = userCache;

		userCachePrototype.users.put(userDTO.getUsername(), userDTO);
		userCacheSingleton.put(userDTO.getUsername(), userDTO);

		var map = new HashMap<String, Map>();
		map.put("prototype", userCachePrototype.users);
		map.put("singleton", userCacheSingleton.getMap());

		return map;
	}

}

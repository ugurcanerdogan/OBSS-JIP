package tr.com.obss.ji.springdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import tr.com.obss.ji.springdemo.cache.UserCache;
import tr.com.obss.ji.springdemo.cache.UserCachePrototype;
import tr.com.obss.ji.springdemo.model.User;
import tr.com.obss.ji.springdemo.model.dto.UserDTO;
import tr.com.obss.ji.springdemo.repo.UserRepository;

@Service
public class UserService {

	private final ApplicationContext applicationContext;

	private final UserRepository userRepository;

	private final UserCache userCache;

	// @Qualifier("userCacheSingleton") gelebilir userCache argüman öncesine ama, @primary
	// tercih ettim.
	public UserService(ApplicationContext applicationContext, UserCache userCache, UserRepository userRepository) {
		this.applicationContext = applicationContext;
		this.userCache = userCache;
		this.userRepository = userRepository;
	}

	public User save(UserDTO userDTO) {

		var user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
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

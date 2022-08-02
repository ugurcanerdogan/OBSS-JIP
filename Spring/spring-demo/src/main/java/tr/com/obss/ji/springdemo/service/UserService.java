package tr.com.obss.ji.springdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import tr.com.obss.ji.springdemo.cache.UserCache;
import tr.com.obss.ji.springdemo.cache.UserCachePrototype;
import tr.com.obss.ji.springdemo.model.UserDTO;

@Service
public class UserService {

	private final ApplicationContext applicationContext;

	private final UserCache userCache;

	// @Qualifier("userCacheSingleton") gelebilir userCache argüman öncesine ama, @primary
	// tercih ettim.
	public UserService(ApplicationContext applicationContext, UserCache userCache) {
		this.applicationContext = applicationContext;
		this.userCache = userCache;
	}

	public Map<String, Map> save(UserDTO userDTO) {
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

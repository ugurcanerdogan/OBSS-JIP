package tr.com.obss.ji.springdemo.cache;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.com.obss.ji.springdemo.model.UserDTO;

@Component
@Scope("singleton")
@Primary
public class UserCacheSingleton implements UserCache {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCacheSingleton.class);

	public Map<String, UserDTO> users;

	@PostConstruct
	public void init() {
		LOGGER.info("Singleton bean constructed.");
		users = new HashMap<>();
	}

	@Override
	public void put(String username, UserDTO userDTO) {
		users.put(username, userDTO);
	}

	@Override
	public Map<String, UserDTO> getMap() {
		return users;
	}

}

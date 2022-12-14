package tr.com.obss.ji.springdemo.cache;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.com.obss.ji.springdemo.model.dto.UserDTO;

@Component
@Scope("prototype")
public class UserCachePrototype implements UserCache {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCachePrototype.class);

	public Map<String, UserDTO> users;

	@PostConstruct
	public void init() {
		LOGGER.info("Prototype bean constructed/initialized.");
		users = new HashMap<>();
	}

	@PreDestroy
	public void destroy() {
		LOGGER.info("Prototype bean destructed/destroyed.");
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

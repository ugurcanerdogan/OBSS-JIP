package tr.com.obss.ji.springdemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tr.com.obss.ji.springdemo.cache.UserCachePrototype;
import tr.com.obss.ji.springdemo.cache.UserCacheSingleton;
import tr.com.obss.ji.springdemo.model.UserDTO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final ApplicationContext applicationContext;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	public UserController(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@GetMapping("")
	public ResponseEntity<?> getUser() {
		LOGGER.info("A successful get request log inside method.");
		return ResponseEntity.ok("A successful get request.");
	}

	@PostMapping("/withoutBody")
	public ResponseEntity<?> createUserWithoutBody() {
		LOGGER.info("A successful post request log inside method.");
		return ResponseEntity.ok("A successful post request.");
	}

	@PostMapping("")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
		LOGGER.info("User info: {} {}", userDTO.getUsername(), userDTO.getPassword());
		return ResponseEntity.ok(userDTO);
	}

	@GetMapping("/throwError")
	public void throwError() throws Exception {
		LOGGER.info("A successful get ERROR request log inside method.");
		throw new Exception();
	}

	@PostMapping("/appContext")
	public ResponseEntity<?> createUserOnContext(@Valid @RequestBody UserDTO userDTO) {
		LOGGER.info("User info: {} {}", userDTO.getUsername(), userDTO.getPassword());

		var userCachePrototype = applicationContext.getBean(UserCachePrototype.class);
		var userCacheSingleton = applicationContext.getBean(UserCacheSingleton.class);

		userCachePrototype.users.put(userDTO.getUsername(), userDTO);
		userCacheSingleton.users.put(userDTO.getUsername(), userDTO);

		var map = new HashMap<String, Map>();
		map.put("prototype", userCachePrototype.users);
		map.put("singleton", userCacheSingleton.users);

		return ResponseEntity.ok(map);
	}

}

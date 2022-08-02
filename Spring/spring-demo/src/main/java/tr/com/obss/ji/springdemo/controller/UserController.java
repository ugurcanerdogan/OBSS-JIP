package tr.com.obss.ji.springdemo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tr.com.obss.ji.springdemo.model.dto.UserDTO;
import tr.com.obss.ji.springdemo.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
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

	@PostMapping("/fakeUser")
	public ResponseEntity<?> createFakeUser(@Valid @RequestBody UserDTO userDTO) {
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
		return ResponseEntity.ok(userService.saveCache(userDTO));

	}

	@PostMapping("")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
		LOGGER.info("User info: {} {}", userDTO.getUsername(), userDTO.getPassword());
		return ResponseEntity.ok(userService.save(userDTO));

	}

}

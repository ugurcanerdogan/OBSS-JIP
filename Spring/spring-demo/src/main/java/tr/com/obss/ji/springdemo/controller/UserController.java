package tr.com.obss.ji.springdemo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tr.com.obss.ji.springdemo.model.UserDTO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping("")
	public ResponseEntity<?> getUser() {
		LOGGER.info("A successful get request log inside method.");
		return ResponseEntity.ok("A successful get request.");
	}

	@PostMapping("")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
		LOGGER.info("User info: {} {}", userDTO.getUsername(), userDTO.getPassword());
		return ResponseEntity.ok("A successful post request.");
	}

	@GetMapping("/throwError")
	public void throwError() throws Exception {
		LOGGER.info("A successful get ERROR request log inside method.");
		throw new Exception();
	}

}

package tr.com.obss.ji.springdemo.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> createUser() {
		LOGGER.info("A successful post request log inside method.");
		return ResponseEntity.ok("A successful post request.");
	}

	@GetMapping("/throwError")
	public void throwError() throws Exception {
		LOGGER.info("A successful get ERROR request log inside method.");
		throw new Exception();
	}

}

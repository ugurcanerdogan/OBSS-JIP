package tr.com.obss.ji.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import tr.com.obss.ji.springdemo.model.User;
import tr.com.obss.ji.springdemo.model.dto.UserDTO;
import tr.com.obss.ji.springdemo.model.dto.UserUpdateDTO;
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
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
	// @Secured("ROLE_ADMIN")// - SECURED
	// @RolesAllowed()// - JSR
	public ResponseEntity<List<User>> getUsers() {
		LOGGER.info("A getAll request has been sent.");
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/by-username")
	public ResponseEntity<User> searchUsers(@RequestParam(name = "username") String username) {
		LOGGER.info("A getByUsername request has been sent.");
		return ResponseEntity.ok(userService.findByUsername(username));
	}

	@GetMapping("/all-by-username")
	public ResponseEntity<List<User>> getUsers(@RequestParam(name = "username") String username) {
		LOGGER.info("A getAllByUsername request has been sent.");
		return ResponseEntity.ok(userService.findAllByUsername(username));
	}

	@GetMapping("/by-id-HQL/{userId}")
	public ResponseEntity<User> getUserByHQL(@PathVariable(name = "userId") long id) {
		LOGGER.info("A get request for HQL has been sent.");
		return ResponseEntity.ok(userService.findByIdWithHQL(id));
	}

	@GetMapping("/by-id-nativeSQL/{userId}")
	public ResponseEntity<User> getUserBySQL(@PathVariable(name = "userId") long id) {
		LOGGER.info("A get request for SQL has been sent.");
		return ResponseEntity.ok(userService.findByIdWithNativeSQL(id));
	}

	@GetMapping("/with-dao-pagination")
	public ResponseEntity<List<User>> getUserWithDaoPagination(
			@RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
		LOGGER.info("A get request for DAO Pagination has been sent.");
		return ResponseEntity.ok(userService.findAllWithDaoPagination(pageNumber, pageSize));
	}

	@GetMapping("/with-jpa-pagination")
	public ResponseEntity<Page<User>> getUserWithJpaPagination(
			@RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
		LOGGER.info("A get request for JPA Pagination has been sent.");
		return ResponseEntity.ok(userService.findAllWithJpaPagination(pageNumber, pageSize));
	}

	@GetMapping("/has-role-user")
	public ResponseEntity<List<User>> getUsersWithUserRole() {
		LOGGER.info("A getByUsername request has been sent.");
		return ResponseEntity.ok(userService.getUsersWithRole(List.of("ROLE_USER")));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable(name = "userId") long id) {
		LOGGER.info("A getById request has been sent.");
		return ResponseEntity.ok(userService.findById(id));
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable(name = "userId") long id,
			@Valid @RequestBody UserUpdateDTO userUpdateDTO) {
		LOGGER.info("A put request has been sent.");
		return ResponseEntity.ok(userService.update(id, userUpdateDTO));
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<User> removeUser(@PathVariable(name = "userId") long id) {
		LOGGER.info("A delete request has been sent.");
		return ResponseEntity.ok(userService.remove(id));
	}

	@PostMapping("")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
		LOGGER.info("A post request has been sent.");
		LOGGER.info("User info: {} {}", userDTO.getUsername(), userDTO.getPassword());
		return ResponseEntity.ok(userService.save(userDTO));

	}

	@GetMapping("/fakeGet")
	public ResponseEntity<?> getFakeUser() {
		LOGGER.info("A successful get request log inside method.");
		return ResponseEntity.ok("A successful get request.");
	}

	@PostMapping("/withoutBody")
	public ResponseEntity<?> createUserWithoutBody() {
		LOGGER.info("A successful post request log inside method.");
		return ResponseEntity.ok("A successful post request.");
	}

	@PostMapping("/fakePost")
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

}

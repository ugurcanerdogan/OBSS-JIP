package tr.com.obss.ji.springdemo.exception;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> handleRuntimeException(HttpServletRequest request, Throwable t) {
		LOGGER.error(t.getMessage(), t);
		var map = new HashMap<>();
		map.put("Error message", "Unknown error occured...");
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<?> handleArithmeticException(HttpServletRequest request, Throwable t) {
		LOGGER.error(t.getMessage(), t);
		var map = new HashMap<>();
		map.put("Error message", "Arithmetic error occured...");
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

package in.ineuron.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// instead of using both @ControllerAdvice, @ResponseBody => we can use @RestController

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleEmployeeNotFoundException(EmployeeNotFoundException e) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage());
		// Set any additional information in the error response object

		return errorResponse;
	}

	// Add additional exception handlers for other exceptions if needed

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setLocalDateTime(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		// Set any additional information in the error response object

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

}

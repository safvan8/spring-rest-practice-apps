package in.ineuron.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandlerMethods {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleTouristNotFoundException(TouristNotFoundException e) {

		System.out.println("------------");
		
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllOtherExceptions(TouristNotFoundException e) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.toString());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}

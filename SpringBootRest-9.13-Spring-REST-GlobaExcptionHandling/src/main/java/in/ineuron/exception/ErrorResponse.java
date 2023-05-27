package in.ineuron.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

	public ErrorResponse() {
		System.out.println("while Exception occured,used to respond with  JSON");
	}

	private LocalDateTime localDateTime;

	private String message;
	// Add any additional fields as needed

	// Getters and setters for the fields
}

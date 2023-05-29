package in.ineuron.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("	")
public class ProducerController {

	@GetMapping("/getWish")
	public ResponseEntity<String> generateWishMessage() {
		int hour = LocalDateTime.now().getHour();

		String message = null;

		if (hour < 14)
			message = "Good Morning";
		else
			message = "Good Night";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/getMessage/{id}/{user}")
	public ResponseEntity<String> getWelcomeMessageById(@PathVariable("id") int id,
			@PathVariable("user") String uname) {
		// Logic to fetch message by id from data source
		String message = "Message Id:" + id + ": Welcome -- " + uname;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}

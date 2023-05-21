package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

	// http://localhost:9999/course/info/5
	@GetMapping("/info/{id}")
	public ResponseEntity<String> getCourseInfo(@PathVariable Integer id) {

		String body = null;
		if (id == 5) {
			body = "Course ID :: 5";
		} else if (id == 6) {
			body = "Course ID :: 6";
		} else {
			body = "Choose Course Id 5/6 ";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(body, HttpStatus.OK);
		return entity;
	}

	// http://localhost:9999/course/info/6/jobready/hyder
	@GetMapping("/info/{id}/jobready/{name}")
	public ResponseEntity<String> getCourseDetails(@PathVariable String id, @PathVariable String name) {
		String body = null;

		if (id.equals("5") && name.equalsIgnoreCase("navinreddy")) {
			body = "Course ID :: 5 and Trainer is :: navinreddy ";
		} else if (id.equals("6") && name.equalsIgnoreCase("hyder")) {
			body = "Course ID :: 6 and Trainer is :: hyder abbas ";
		} else {
			body = "Contact ineuron webiste for the information";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(body, HttpStatus.OK);
		return entity;
	}

}

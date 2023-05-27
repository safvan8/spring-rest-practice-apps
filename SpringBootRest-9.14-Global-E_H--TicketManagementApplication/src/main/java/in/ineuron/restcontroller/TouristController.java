package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristMgmtService touristMgmtService;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {

		String resultMsg = touristMgmtService.registerTourist(tourist);

		// if tourist enrolled succesfully
		return new ResponseEntity<String>(resultMsg, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTouristDetails() {

		List<Tourist> tourisLis = touristMgmtService.fetchAllTousristDetails();
		// if retrieving success
		return new ResponseEntity<List<Tourist>>(tourisLis, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> getTouristRecordByID(@PathVariable("id") Integer tId) {
		Tourist tourist = touristMgmtService.findTouristById(tId);

		// if tourist record is found
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
	}

	@PutMapping("/fullModify")
	public ResponseEntity<String> modifyTouristObjCompletely(@RequestBody Tourist tourist) {
		// if success
		String successMessage = touristMgmtService.updateToursitByDetails(tourist);
		return new ResponseEntity<String>(successMessage, HttpStatus.OK);
	}

	@PatchMapping("/modifyBudget/{id}/{hikePercentage}")
	public ResponseEntity<String> modifyTouristBudgetByIdId(@PathVariable("id") Integer touristId,
			@PathVariable Float hikePercentage) {
		String statusMsg = touristMgmtService.updateTouristBudgetById(touristId, hikePercentage);

		return new ResponseEntity<String>(statusMsg, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable("id") Integer tid) {

		String successMsg = touristMgmtService.deleteTouristById(tid);
		return new ResponseEntity<String>(successMsg, HttpStatus.OK);
	}
}

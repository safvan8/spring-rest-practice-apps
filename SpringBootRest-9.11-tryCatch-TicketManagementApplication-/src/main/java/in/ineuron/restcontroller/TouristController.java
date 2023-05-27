package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
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

		try {
			String resultMsg = touristMgmtService.registerTourist(tourist);

			// if tourist enrolled succesfully
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem occured while registering Tourist",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTouristDetails() {

		try {
			List<Tourist> tourisLis = touristMgmtService.fetchAllTousristDetails();
			// if retrieving success
			return new ResponseEntity<List<Tourist>>(tourisLis, HttpStatus.OK);
		} catch (Exception e) {
			// if retrieving failed
			return new ResponseEntity<String>("Problem occured while fetching all  tourist records",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> getTouristRecordByID(@PathVariable("id") Integer tId) {
		try {
			Tourist tourist = touristMgmtService.findTouristById(tId);

			// if tourist record is found
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			// if record not found , we are thrwing Exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}

	@PutMapping("/fullModify")
	public ResponseEntity<String> modifyTouristObjCompletely(@RequestBody Tourist tourist) {
		try {
			// if success
			String successMessage = touristMgmtService.updateToursitByDetails(tourist);
			return new ResponseEntity<String>(successMessage, HttpStatus.OK);
		} catch (Exception e) {
			// if records not available , this will throw Exception
			return new ResponseEntity<String>(e.getCause() + e.getMessage(), HttpStatus.NOT_MODIFIED);
		}
	}

	@PatchMapping("/modifyBudget/{id}/{hikePercentage}")
	public ResponseEntity<String> modifyTouristBudgetByIdId(@PathVariable("id") Integer touristId,
			@PathVariable Float hikePercentage) {
		try {
			String statusMsg = touristMgmtService.updateTouristBudgetById(touristId, hikePercentage);

			return new ResponseEntity<String>(statusMsg, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable("id") Integer tid) {
		try {
			String successMsg = touristMgmtService.deleteTouristById(tid);
			return new ResponseEntity<String>(successMsg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

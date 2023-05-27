package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ITouristRepo;
import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {

		Integer regTouristId = touristRepo.save(tourist).getTid();

		return "Tourist registered Successfully with id :" + regTouristId;
	}

	@Override
	public List<Tourist> fetchAllTousristDetails() {

		// getting all records
		return (List<Tourist>) touristRepo.findAll();
	}

	@Override
	public Tourist findTouristById(Integer id) {

// Way 1:		
//		Optional<Tourist> tourist = touristRepo.findById(id);
// Throwing NPE is not reccomended , instead a user defined meaning  full exception;		
//		if (tourist.isPresent())
//			return tourist.get();
//		throw new NullPointerException("Tourist not found with the id :" + id);

// way 2:		Optional<Tourist> tourist = touristRepo.findById(id);		
//		if (tourist.isPresent())
//			return tourist.get();
//		throw new TouristNotFoundException("Tourist not found with the id :" + id);

		// doing above Cutsom exception way in one line
		// way 3:
		return touristRepo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist not found with the id :" + id));
	}

	@Override
	public String updateToursitByDetails(Tourist tourist) {

		Optional<Tourist> result = touristRepo.findById(tourist.getTid());

		if (result.isPresent()) {
			touristRepo.save(tourist); // save method can do both save and update in Data JPA based on ID
			return "Toursit record updated from the Id: " + tourist.getTid();
		} else {
			throw new TouristNotFoundException("Tourist not found with the id :" + tourist.getTid());
		}

	}

	@Override
	public String updateTouristBudgetById(Integer tid, Float hikePercentage) {

		Optional<Tourist> result = touristRepo.findById(tid);

		// checking if the Tourist availble or not
		if (result.isPresent()) {
			// apply hike and update
			Tourist tourist = result.get();
			Double budget = tourist.getBudget();
			Double newBudget = budget + (budget * hikePercentage / 100);
			tourist.setBudget(newBudget);

			// updating new Budget
			touristRepo.save(tourist);

			return "Tourist budget updated for the id " + tid;
		} else
			throw new TouristNotFoundException("Toursit record for the id :" + tid + " is not found");
	}

	@Override
	public String deleteTouristById(Integer tid) {

		try {
			// if not found throw EmptyResultDataAccessException
			touristRepo.deleteById(tid);
			return "tourist record deleted for the id" + tid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TouristNotFoundException("Tourist not found for the id " + tid);
		}
	}
}

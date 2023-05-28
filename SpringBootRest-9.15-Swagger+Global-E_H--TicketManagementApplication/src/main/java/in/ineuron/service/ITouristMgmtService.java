package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);

	public List<Tourist> fetchAllTousristDetails();

	public Tourist findTouristById(Integer tid);

	public String updateToursitByDetails(Tourist tourist);
	
	public String updateTouristBudgetById(Integer tId,Float hikePercentage);
	
	public String deleteTouristById(Integer tid);

}

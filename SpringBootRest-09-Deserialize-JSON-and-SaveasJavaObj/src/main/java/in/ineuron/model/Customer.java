package in.ineuron.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private Float billAmount;

	// array
	private String[] teamNames;
	// List and array is same in JSON format

	private List<String> footballers;

	private Set<Long> phoneNumbers;

	public Map<String, Object> idDetails;

	// HAS-A Variable
	public Company company;
}
package in.ineuron.restcontroller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Company;
import in.ineuron.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@GetMapping("/report/{id}")
	public ResponseEntity<Customer> showCustomer(@PathVariable("id") Integer customerId) {

		// in real life this object will be retrived from DB
		Customer customer = new Customer();
		customer.setCno(customerId);
		customer.setCname("sachin");
		customer.setBillAmount(54.5f);

		customer.setTeamNames(new String[] { "IND", "MI", "AsiaXI", "Mumbai" });

		customer.setFootballers(List.of("10th", "12th", "Engineering"));
		customer.setPhoneNumbers(Set.of(9994445556L, 994349845L, 98765678L));
		customer.setIdDetails(Map.of("adhar", 99453123432L, "panNo", "DOOPQRCL12"));

		// setter injection of HAS A varible
		customer.setCompany(new Company("MI", "IPL", "Mumbai", 45));

		ResponseEntity<Customer> respEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);

		return respEntity;
	}
}

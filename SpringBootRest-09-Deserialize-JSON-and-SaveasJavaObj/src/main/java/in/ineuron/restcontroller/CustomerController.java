package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {

		String result = "Customer Object saved  with Customer number: " + customer.getCno();

		System.out.println("Customer Object content after deserilizaion:");
		System.out.println(customer);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}
}

package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.exception.EmployeeNotFoundException;
import in.ineuron.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping("findEmp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int eId) {

		Employee employee = null;

		// write code to retrive employee object from db by
		// connecting to service and dao

		if (employee == null) {
			throw new EmployeeNotFoundException("Employee not found with ID: " + eId);
		}

		// if success below code will be executed
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}

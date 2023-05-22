package in.ineuron.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;

public class TestApp {
	public static void main(String[] args) {
		// Create Mapper Object
		ObjectMapper mapper = new ObjectMapper();

		// using mapper object, read data from JSON file and convert it into pojo
		// objects

		// using mapper object to get data from JSOn file and conert in to java objects
		// form-- in this case checked exception delegateed to caller
		Customer customer = null;
		try {
			System.out.println("-----------");
			customer = mapper.readValue(new File("data/sample-full.json"), Customer.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n priting customer object============");
		System.out.println(customer);
	}
}

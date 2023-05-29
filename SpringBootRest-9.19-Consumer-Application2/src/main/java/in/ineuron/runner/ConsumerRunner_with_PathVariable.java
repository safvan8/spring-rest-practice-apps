package in.ineuron.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRunner_with_PathVariable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ConsumerRunner_with_PathVariable.run()...... executing");

		RestTemplate restTemplate = new RestTemplate();

		String serviceURL = "http://localhost:9999/Producer-Application/api/producer/getMessage/{id}/{user}"; // Provide the URL of the RESTful service

		// Create a map to supply values to the RestController using @PathVariable
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 7); // Provide the value for the "id" path variable
		map.put("user", "dhoni"); // Provide the value for the "name" path variable

		// Make a GET request to the service URL with the path variables
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceURL, String.class, map);

		System.out.println("Response body              : " + responseEntity.getBody());
		System.out.println("Response Status code value : " + responseEntity.getStatusCodeValue());
		System.out.println("Response header            : " + responseEntity.getHeaders());
	}
}

package in.ineuron.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRunner_POST_JSON_for_Save implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ConsumerRunner_POST_JSON_for_Save.run()...........");

		RestTemplate restTemplate = new RestTemplate();

		String endPointURL = "http://localhost:9999/Producer-Application/api/actor/save";

		// Sending the information to @RequestBody(JSON data)
		// we are pre-infoming the sending data is JSON in requestinh header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// hard corded jason for sending trough request body for saving
		String jsonForSave = "{\r\n"
				+ "    \"aid\" : 2,\r\n"
				+ "    \"name\" : \"Ozil\",\r\n"
				+ "    \"age\" : \"33f\",\r\n"
				+ "    \"type\" : \"cricketer\"\r\n"
				+ "}";

		HttpEntity<String> request = new HttpEntity<>(jsonForSave, headers);

		// sending post request from application
		ResponseEntity<String> reponseFromRestAPI = restTemplate.postForEntity(endPointURL, request, String.class);

		System.out.println("Response Body :" + reponseFromRestAPI.getBody());
		System.out.println("Response headers :" + reponseFromRestAPI.getHeaders());
		System.out.println("Response code :" + reponseFromRestAPI.getStatusCode().toString());
	}
}

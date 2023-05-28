package in.ineuron;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ConsumerRunner .. started execution.........");

		RestTemplate restTemplate = new RestTemplate();

		String serviceURL = "http://localhost:9999/Producer-Application/api/producer/getWish";

		ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceURL, String.class);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");

	}

}

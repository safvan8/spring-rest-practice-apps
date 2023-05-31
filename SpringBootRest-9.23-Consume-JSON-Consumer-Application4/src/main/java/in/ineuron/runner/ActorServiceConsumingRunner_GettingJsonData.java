package in.ineuron.runner;

import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.ineuron.model.Actor;

@Component
public class ActorServiceConsumingRunner_GettingJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_GettingJsonData.run()");

		RestTemplate restTemplate = new RestTemplate();

		String endpointURL = "http://localhost:9999/Producer-Application/api/actor/find/{id}";

		HashMap<String, Object> map = new HashMap<>();

		map.put("id", 7);

		ResponseEntity<Actor> response = restTemplate.getForEntity(endpointURL, Actor.class, map);
		System.out.println("Response Body contents :" + response.getBody());
		System.out.println("ResponseStatus Code Value :: " + response.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + response.getStatusCode().name());
		System.out.println("Response Headers : " + response.getHeaders());
	}
}

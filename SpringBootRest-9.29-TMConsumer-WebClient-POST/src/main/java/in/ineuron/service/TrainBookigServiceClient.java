package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@Service("service")
public class TrainBookigServiceClient {

	private static final String REST_END_URL = "http://localhost:9999/ProducerApp/api/ticket/register";

	public void call_synchrnous_RestAPI_POST() {
		
		System.out.println("*****Synchronous -POST-REST API Call started");
		
		WebClient webClient = WebClient.create();

		PassengerInfo body = new PassengerInfo();
		body.setFirstName("nitin");
		body.setLastName("manjunath");
		body.setJourneyDate("22/06/2023");
		body.setFrom("bengaluru");
		body.setTo("pune");
		body.setTrainNumber("BNG-PUN-1234");

		Ticket response = webClient.post()
								.uri(REST_END_URL)
								.accept(MediaType.APPLICATION_JSON)
								.body(BodyInserters.fromValue(body))
								.retrieve()
								.bodyToMono(Ticket.class)
								.block(); // synchronous call

		System.out.println("***response recived from REST API");
		System.out.println(response);

		System.out.println("*****Synchronous -POST-REST API Call Ended");

	}
	
	public void call_Asynchrnous_RestAPI_POST() {
		System.out.println("##### Asynchronous -POST-REST API Call started");

		WebClient webClient = WebClient.create();

		PassengerInfo passenger = new PassengerInfo();
		passenger.setFirstName("Mesut");
		passenger.setLastName("Ozil");
		passenger.setJourneyDate("22/06/2023");
		passenger.setFrom("Turkey");
		passenger.setTo("KSA");
		passenger.setTrainNumber("TRK-KSA-76876");
		
		webClient
			.post()
			.uri(REST_END_URL)
			.accept(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromValue(passenger))
			.retrieve()
			.bodyToMono(Ticket.class)
			.subscribe(ticket->{
				 // Callback (Auto calling) method invoked when the response is received
				System.out.println("***Response recived :Consuming response from  REST API: push to KAFKA");
                System.out.println(ticket);
			});
		System.out.println("##### Asynchronous -POST-REST API Call Ended");
	}
}

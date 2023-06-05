package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.response.CurrencyResponse;

@Service
public class CurrencyConsumingService {

	private static final String REST_END_POINT_URL = "http://localhost:9999/Producer-Application/api/currency/getCurrencyExchangeCost/from/USD/to/INR";

	public void RestAPI_Synchronous_call(String fromCurrency, String toCurrency) {
		// Sending synchronous request
		WebClient webClient = WebClient.create();

		System.out.println("Synchronous REST API Call started....");

		// Send a GET request synchronously and block until the response is received
		CurrencyResponse response = webClient.get()
				.uri(REST_END_POINT_URL, fromCurrency, toCurrency) // Set the URI with path variables
				.accept(MediaType.APPLICATION_JSON) // Set the request's "Accept" header
				.retrieve() // Initiate the request
				.bodyToMono(CurrencyResponse.class) // Extract the response body as Mono<CurrencyResponse>
				.block(); // Block the execution until the response is received

		// Consume the received REST API response here
		System.out.println(response);

		System.out.println("Synchronous REST API Call Ended....");
	}

	public void RestAPI_Asynchronous_call(String fromCurrency, String toCurrency) {
		// Sending asynchronous request
		WebClient webClient = WebClient.create();

		System.out.println("### Asynchronous REST API Call started ");

		// Send a GET request asynchronously and subscribe to receive the response
		webClient
				.get()
				.uri(REST_END_POINT_URL, fromCurrency, toCurrency) // Set the URI with path variables
				.accept(MediaType.APPLICATION_JSON) // Set the request's "Accept" header
				.retrieve() // Initiate the request
				.bodyToMono(CurrencyResponse.class) // Extract the response body as Mono<CurrencyResponse>
				.subscribe(CurrencyConsumingService::consume_asynchronous_call_response); // Subscribe to the response and provide a callback method

		System.out.println("### Asynchronous REST API Call Ended ");
	}

	public static void consume_asynchronous_call_response(CurrencyResponse response) {
		System.out.println(response);
		// Use the response object as per the needs [e.g., push to Apache Kafka]
	}
}

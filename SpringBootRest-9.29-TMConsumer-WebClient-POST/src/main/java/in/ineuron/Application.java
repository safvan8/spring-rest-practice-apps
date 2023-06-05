package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.service.TrainBookigServiceClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		TrainBookigServiceClient bookingService = context.getBean("service", TrainBookigServiceClient.class);

		// calling method to send synchronous POST request to REST API
		bookingService.call_synchrnous_RestAPI_POST();

		// sleeping for 3 seconds
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.println();
		}
		
		// calling method to send Asynchronous POST request to REST API
		bookingService.call_Asynchrnous_RestAPI_POST();
	}
}

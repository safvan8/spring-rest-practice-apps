package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.CurrencyConsumingService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		CurrencyConsumingService service = context.getBean(CurrencyConsumingService.class);

		// calling method to performing synchronized REST API call
		service.RestAPI_Synchronous_call("USD", "INR");

		// sleeping for 3 seconds
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.println();
		}

		//  calling method to performing asynchronized REST API call
		service.RestAPI_Asynchronous_call("USD", "INR");
	}
}

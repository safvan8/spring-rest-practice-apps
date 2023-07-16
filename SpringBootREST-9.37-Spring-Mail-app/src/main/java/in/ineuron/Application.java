package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IPurchaseOrderService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		IPurchaseOrderService service = applicationContext.getBean(IPurchaseOrderService.class);

		String status = service.purchaseOrder(new String[] { "BMW M4", "Rolls Royce", "Porche" },
				new double[] { 1000.0, 87789.0, 7678.98 },
				new String[] { "safvanpmcz@gmail.com", "safvanpmcz@gmail.com" });
		
		System.out.println(status);

	}

}

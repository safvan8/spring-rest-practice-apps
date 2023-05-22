package in.ineuron.main;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Product;

public class TestApp {
	public static void main(String[] args) {
		try {
			// Create Object Mapper
			ObjectMapper mapper = new ObjectMapper();

			Product product = new Product();
			product = setObjectData(product);
			System.out.println("In java format ====:: " + product);

			// Converting java object into JsonString
			String jsonData = mapper.writeValueAsString(product);
			System.out.println("In json format ====:: " + jsonData);

			// Writing the data to json file
			// Converting java object into JsonString will happens here also before writing
			// to file
			mapper.writeValue(new File("product-list.json"), product);
			System.out.println("Wrote the data to json file ====");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Product setObjectData(Product product) {
		product.setPid(10);
		product.setPname("fossil");
		product.setPrice(24556.0);
		product.setTypes(new String[] { "Type-1", "Type-2", "Type-3" });

		return product;
	}
}

package in.ineuron.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) // Specify the Swagger version
				.select() // Start defining the selection criteria for the APIs
				.apis(RequestHandlerSelectors.basePackage("in.ineuron.restcontroller")) // Specify the base package for the RestControllers
				.paths(PathSelectors.regex("/api/tourist.*")) // Specify the request paths that should be included
				.build() // Build the Docket object
				.useDefaultResponseMessages(true) // Use default response messages
				.apiInfo(getApiInfo()); // Provide API information
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("safvan", "http://www.ineuron.ai/course", "safvan@ineuron.ai");

		return new ApiInfo("TouristInfo", // Specify the title of the API documentation
				"Gives information about tourist activities", // Specify the description of the API documentation
				"3.4.RELEASE", // Specify the version of the API documentation
				"http:www.hcl.com/license", // Specify the terms of services URL
				contact, // Specify the contact information
				"GNU PUBLIC", // Specify the license name
				"https://www.apache.org/licenses/LICENSE-2.0.html", // Specify the license URL
				Collections.emptyList()); // Specify the vendor extensions (if any)
	}
}

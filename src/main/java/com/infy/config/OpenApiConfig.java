package com.infy.config;

import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Value("${infy.dev-url}")
	String dev_url;
	
	@Value("${infy.prod-url}")
	String prod_url;
	
	@Bean
	 public OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setUrl(dev_url);
	    devServer.setDescription("Server URL in Development environment");

	    Server prodServer = new Server();
	    prodServer.setUrl(prod_url);
	    prodServer.setDescription("Server URL in Production environment");

	    Contact contact = new Contact();
	    contact.setEmail("narendra.korade97@gmail.com");
	    contact.setName("Infosys");
	    contact.setUrl("https://www.infosys.com");
	    
	    Info info = new Info()
		        .title("Product CRUD API Using Spring Boot and Hibernate")
		        .version("1.0")
		        .contact(contact)
		        .description("This API exposes endpoints to manage Products.").termsOfService("https://www.infosys.com/terms");
//		        .license(mitLicense);

		    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	}
}

package com.firstproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Todo Application")
						.version("1.0")
						.description("This todo application developed by ammarthedeveloper as he's first fully functional api using spring boot")
						.termsOfService("http://ammarthedeveloper.com/reviews")
						.contact(new Contact()
								.name("Ammar Ansari")
								.email("ammarthedeveloper@gmail.com")
								.url("https://github.com/ammarthedeveloper"))
						.license(new License()
								.name("ammar license")
								.url("http://ammarlicense.org"))
						);
	}

}

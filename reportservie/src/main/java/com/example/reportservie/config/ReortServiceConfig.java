package com.example.reportservie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ReortServiceConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/vi/api/**") 
						//.allowedOrigins("http://localhost:4200") // dissable csrf throw web requests
						.allowedMethods("GET", "POST", "PUT", "DELETE") 
						.allowedHeaders("*") 
						.allowCredentials(true); 
			}
		};
	}

}

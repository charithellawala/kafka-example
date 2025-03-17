package com.example.filewriter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class FileWriterConfiguration {

	/* will be needed once we handle webRequest via web ui */
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/vi/api/**") 
//						.allowedOrigins("http://localhost:4200") 
//						.allowedMethods("GET", "POST", "PUT", "DELETE")
//						.allowedHeaders("*") 
//						.allowCredentials(true); 
//			}
//		};
//	}

}

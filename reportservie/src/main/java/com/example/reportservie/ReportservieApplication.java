package com.example.reportservie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ReportservieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportservieApplication.class, args);
	}

}

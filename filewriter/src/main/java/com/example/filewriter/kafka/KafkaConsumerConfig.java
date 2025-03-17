package com.example.filewriter.kafka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableKafka
@EnableKafkaStreams
@Slf4j
public class KafkaConsumerConfig {

	@Value("${file.report.directory}")
	private String reportDirectory;

	@Bean
	public KStream<String, String> kafkaStream(StreamsBuilder streamsBuilder) {
		// Consume messages from the "report-requests" topic
		KStream<String, String> stream = streamsBuilder.stream("report-requests",
				Consumed.with(Serdes.String(), Serdes.String()));

		// Process each message
		stream.foreach((key, value) -> {
			String[] parts = value.split(",");
			String reportName = parts[0];
			String reportType = parts[1];

			// Define the absolute path for the report file
			String filePath = reportDirectory + reportName + ".csv";

			File directory = new File(reportDirectory);
			if (!directory.exists()) {
				directory.mkdirs(); 
			}

			// Generate the report file
			try (FileWriter writer = new FileWriter(filePath)) {
				writer.write("Report Name, Report Type, Status, Filelink " + "\n");
				
				writer.write(reportName +","+ reportType + ","+ "In-Progress" + "," + filePath);				
//				writer.write("Report Name: " + reportName + "\n");
//				writer.write("Report Type: " + reportType + "\n");
//				writer.write("Data: Mocked data for " + reportName + "\n");
				
		    	log.info("Report generated in the directory: {}" + filePath);

			} catch (IOException e) {
				log.error("Error Occured While Generating the Report: " + e.getMessage());
			}
		});

		return stream;
	}


}

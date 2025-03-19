package com.example.reportservie.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducerServiceImpl {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducerServiceImpl(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String topic, String message) {
		try {
			log.info("Sending Topic ReportName, Report Type & ReportId : "+ message + " to Topic: " + topic);
			kafkaTemplate.send(topic, message);
			log.info("Report Topic send...!!");
		} catch (Exception ex) {
			log.error("exception occured while sending the topic: {}" + ex.getMessage());
			throw ex;

		}

	}

}

package com.example.filewriter.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.filewriter.service.ReportServiceImpl;

@Service
public class ReportKafkaConsumerServiceImpl {

	@Autowired
	private ReportServiceImpl reportService;

	/* kafka listeners instead of streams
	@KafkaListener(topics = "report-requests", groupId = "file-writer-group")
	public void listen(String message) {
		String[] parts = message.split(",");
		String reportName = parts[0];
		String reportType = parts[1];
		reportService.generateReport(reportName, reportType);
	}
	*/

}

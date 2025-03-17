package com.example.reportservie.controller;

import java.util.List;

//import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reportservie.kafka.service.KafkaProducerServiceImpl;
import com.example.reportservie.model.Report;
import com.example.reportservie.repository.ReportRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/v1/reports")
public class ReportController {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private KafkaProducerServiceImpl kafkaProducerService;

	@Value("${file.report.directory}")
	private String reportDirectory;

	@GetMapping
	public List<Report> getReports() {
		return reportRepository.findAll();
	}

	@PostMapping
	public Report createReport(@RequestBody Report report) {
		report.setStatus("in-progress");
		String filePath = reportDirectory + report.getReportName() + ".csv";
		report.setFileLink(filePath);

		try {
			reportRepository.save(report);
		} catch (Exception ex) {
			log.error("exception occured while saving in the database: {}" + ex.getMessage());
		}

		kafkaProducerService.sendMessage("report-requests", report.getReportName() + " ," + report.getReportType());
		return report;
	}

}

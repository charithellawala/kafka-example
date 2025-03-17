package com.example.reportservie.controller;

import java.util.List;

//import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reportservie.kafka.service.KafkaProducerServiceImpl;
import com.example.reportservie.model.Report;
import com.example.reportservie.repository.ReportRepository;
import com.example.reportservie.service.ReportServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/v1/api/reports")
public class ReportController {

	@Autowired
	private ReportServiceImpl reportService;

	@Autowired
	private KafkaProducerServiceImpl kafkaProducerService;

	@Value("${file.report.directory}")
	private String reportDirectory;

	@GetMapping("/getall")
	public ResponseEntity<List<Report>> getReports() {
        return ResponseEntity.ok(reportService.getAllReports());
	}

	@PostMapping("/report")
	public ResponseEntity<Report> CreateReport(@RequestBody Report report) {
		
		report.setStatus("in-progress");
		String filePath = reportDirectory + report.getReportName() + ".csv";
		report.setFileLink(filePath);

		kafkaProducerService.sendMessage("report-requests", report.getReportName() + " ," + report.getReportType());
		return ResponseEntity.ok(reportService.createReport(report));
	}
	

}

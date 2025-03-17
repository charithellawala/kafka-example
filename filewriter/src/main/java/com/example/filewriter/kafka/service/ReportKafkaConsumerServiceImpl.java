package com.example.filewriter.kafka.service;

public class ReportKafkaConsumerServiceImpl {

	/* kafka listeners instead of streams
	@Autowired
	private ReportServiceImpl reportService;

	
	@KafkaListener(topics = "report-requests", groupId = "file-writer-group")
	public void listen(String message) {
		String[] parts = message.split(",");
		String reportName = parts[0];
		String reportType = parts[1];
		reportService.generateReport(reportName, reportType);
	}
	*/

}

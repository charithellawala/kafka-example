package com.example.filewriter.service;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.filewriter.model.Report;
import com.example.filewriter.repository.ReportRepository;

@Service
public class ReportServiceImpl {

	@Value("${file.report.directory}")
	private String reportDirectory;

	@Autowired
	private ReportRepository reportRepository;

	public void generateReport(String reportName, String reportType) {

		String filePath = reportDirectory + reportName + ".csv";
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write("Report Type: " + reportType + "\n");
			writer.write("Data: Mocked data for " + reportName + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// if we need to save report in db
		Report report = new Report();
		report.setReportName(reportName);
		report.setReportType(reportType);
		report.setStatus("ready");
		report.setFileLink("http://localhost/reports/" + reportName + ".csv");
		reportRepository.save(report);
	}

}

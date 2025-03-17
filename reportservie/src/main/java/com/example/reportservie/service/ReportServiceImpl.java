package com.example.reportservie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reportservie.model.Report;
import com.example.reportservie.repository.ReportRepository;

@Service
public class ReportServiceImpl {

	private final ReportRepository reportRepository;

	public ReportServiceImpl(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}
	
	public List<Report> getAllReports(){
		return reportRepository.findAll();
	}
	
	public Report createReport(Report report) {
		report.setStatus("in-progress");
		return reportRepository.save(report);
	}

}

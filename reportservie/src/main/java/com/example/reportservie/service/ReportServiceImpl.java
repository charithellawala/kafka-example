package com.example.reportservie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reportservie.controller.ReportController;
import com.example.reportservie.model.Report;
import com.example.reportservie.repository.ReportRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportServiceImpl {

	private final ReportRepository reportRepository;

	public ReportServiceImpl(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}
	
	public List<Report> getAllReports(){
		log.info("Calling All The Existing Reports From Database..!!");
		return reportRepository.findAll();
	}
	
	public Report createReport(Report report) {
		try {
			log.info("Saving the report in DataBase...!!");
			return reportRepository.save(report);
		} catch (Exception ex) {
			log.error("exception occured while saving in the database: {}" + ex.getMessage());
		}
		return null;
	}

}

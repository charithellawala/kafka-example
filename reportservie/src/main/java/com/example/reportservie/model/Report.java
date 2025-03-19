package com.example.reportservie.model;

import com.example.reportservie.common.model.ReportType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Report {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportName;
    
    @Enumerated(EnumType.STRING)
    private ReportType reportType;
    private String status;
    private String fileLink;

}

package com.example.reportservie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reportservie.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{
	
}

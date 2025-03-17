package com.example.filewriter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.filewriter.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}

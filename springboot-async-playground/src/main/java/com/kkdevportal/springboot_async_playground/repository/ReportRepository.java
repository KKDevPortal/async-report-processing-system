package com.kkdevportal.springboot_async_playground.repository;

import com.kkdevportal.springboot_async_playground.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}

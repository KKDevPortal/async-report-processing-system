package com.kkdevportal.springboot_async_playground.service;

import com.kkdevportal.springboot_async_playground.entity.Report;
import com.kkdevportal.springboot_async_playground.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AsyncReportService {
    private final ReportRepository reportRepository;

    @Async("asyncExecutor")
    public void generateReport(Long reportId) {
        try {
            log.info("Starting report generation in thread: {}", Thread.currentThread().getName());
            Thread.sleep(10000);

            Report report = reportRepository.findById(reportId).orElseThrow();
            report.setStatus("COMPLETED");

            reportRepository.save(report);
            log.info("Finished report generation in thread: {}", Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

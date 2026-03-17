package com.kkdevportal.springboot_async_playground.service;

import com.kkdevportal.springboot_async_playground.entity.Report;
import com.kkdevportal.springboot_async_playground.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final AsyncReportService asyncReportService;

    public String createReport(String name) {
        Report report = Report.builder()
                .reportName(name)
                .status("PROCESSING")
                .build();

        report = reportRepository.save(report);
        asyncReportService.generateReport(report.getId());

        return "Report processing started with id: " + report.getId();
    }
}

package com.kkdevportal.springboot_async_playground.controller;

import com.kkdevportal.springboot_async_playground.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping("/reports")
    public String generateReport(@RequestParam String name) {
        return reportService.createReport(name);
    }

}

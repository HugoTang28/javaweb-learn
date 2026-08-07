package com.example.controller;

import com.example.pojo.JobOption;
import com.example.pojo.Result;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
  @Autowired
  private ReportService reportService;

  // 统计员工职位数据
  @GetMapping("/empJobData")
  public Result getEmpJobData() {
    log.info("获取员工职位数据");
    JobOption jobOption = reportService.getEmpJobData();
    return Result.success(jobOption);
  }
}

package com.example.controller;

import com.example.pojo.JobOption;
import com.example.pojo.Result;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

  // 统计员工性别数据
  @GetMapping("/empGenderData")
  public Result getEmpGenderData() {
    log.info("获取员工性别数据");
    List<Map<String, Object>> genderList = reportService.getEmpGenderData();
    return Result.success(genderList);
  }
}

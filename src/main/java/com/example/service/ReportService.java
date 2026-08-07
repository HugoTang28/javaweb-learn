package com.example.service;

import com.example.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
  /**
   * 统计员工职位数据
   * @return
   */
  JobOption getEmpJobData();

  /**
   * 统计员工性别数据
   * @return
   */
  List<Map<String, Object>> getEmpGenderData();
}

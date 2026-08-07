package com.example.service;

import com.example.pojo.JobOption;

public interface ReportService {
  /**
   * 统计员工职位数据
   * @return
   */
  JobOption getEmpJobData();
}

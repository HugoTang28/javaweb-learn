package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.JobOption;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportImplService implements ReportService {
  @Autowired
  private EmpMapper empMapper;

  @Override
  public JobOption getEmpJobData() {
    // 1.调用mapper接口，获取统计数据
    List<Map<String, Object>> list = empMapper.countEmpJobData(); // map: position=xx, count=xx
    // 组装结果，并返回
    List<Object> jobList = list.stream().map(map -> map.get("position")).toList();
    List<Object> dataList = list.stream().map(map -> map.get("count")).toList();
    return new JobOption(jobList, dataList);
  }

  // 统计员工性别数据
  @Override
  public List<Map<String, Object>> getEmpGenderData() {
    return empMapper.countEmpGenderData();
  }
}

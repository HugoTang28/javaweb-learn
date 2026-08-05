package com.example.service.impl;

import com.example.mapper.EmpLogMapper;
import com.example.pojo.EmpLog;
import com.example.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogImplService implements EmpLogService {
  @Autowired
  private EmpLogMapper empLogMapper;

  @Transactional(propagation = Propagation.REQUIRES_NEW) // REQUIRES_NEW需要在一个新的事物中运行
  @Override
  public void insertLog(EmpLog empLog) {
    empLogMapper.insert(empLog);
  }
}

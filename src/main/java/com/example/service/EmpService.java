package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
  /**
   * 分页查询
   */
  // PageResult<Emp> findByPage(Integer page, Integer pagesize,
  //                            String namme, Integer gender,
  //                           LocalDate begin, LocalDate end);

  /**
   * 分页查询
   */
  PageResult<Emp> findByPage(EmpQueryParam empQueryParam);

  /**
   * 新增员工
   */
  void save(Emp emp);
}

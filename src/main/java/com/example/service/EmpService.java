package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;

public interface EmpService {
  /**
   * 分页查询
   * @param page 当前页
   * @param pagesize 每页记录数
   * @return
   */
  PageResult<Emp> findByPage(Integer page, Integer pagesize);
}

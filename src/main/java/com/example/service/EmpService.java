package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;

import java.util.List;

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

  void delete(List<Integer> ids);

  Emp getInfo(Integer id);

  /**
   * 修改员工信息
   * @param emp
   */
  void update(Emp emp);
}

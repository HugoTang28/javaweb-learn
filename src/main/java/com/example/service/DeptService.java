package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
  /**
   * 查询全部部门数据
   * @return
   */
  List<Dept> findAll();

  void delete(Integer id);

  void add(Dept dept);

  Dept findById(Integer id);

  void update(Dept dept);
}

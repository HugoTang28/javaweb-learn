package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
  @Autowired
  private EmpMapper empMapper;

  // @Override
  // public PageResult<Emp> findByPage(Integer page, Integer pagesize) {
  //   // 引入pageHelper
  //
  //   // 1、调用mapper接口，查询总记录数
  //   Long total = empMapper.count();
  //   // 2、调用mapper接口，查询分页数据
  //   Integer start = (page - 1) * pagesize;
  //   List<Emp> rows = empMapper.list();
  //   // 3、封装PageResult对象，返回
  //   return new PageResult<Emp>(total, rows);
  // }


  // 基于pageHelper查询
  // @Override
  public PageResult<Emp> findByPage(Integer page, Integer pagesize) {
    // 设置pageHelper分页参数
    PageHelper.startPage(page, pagesize);

    // 执行查询
    List<Emp> empList = empMapper.list();

    // 解析查询结果，封装PageResult对象，返回
    Page<Emp> p = (Page<Emp>) empList;
    return new PageResult<Emp>(p.getTotal(),p.getResult());
  }
}

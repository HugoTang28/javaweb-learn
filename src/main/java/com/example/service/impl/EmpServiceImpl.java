package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpLogService;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
  @Autowired
  private EmpMapper empMapper;
  @Autowired
  private EmpExprMapper empExprMapper;
  @Autowired
  private EmpLogService empLogService;

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
  // public PageResult<Emp> findByPage(Integer page, Integer pagesize, String namme, Integer gender,
  //                                   LocalDate begin, LocalDate end) {
  //   // 设置pageHelper分页参数
  //   PageHelper.startPage(page, pagesize);
  //
  //   // 执行查询
  //   List<Emp> empList = empMapper.list(namme,gender,
  //       begin, end);
  //
  //   // 解析查询结果，封装PageResult对象，返回
  //   Page<Emp> p = (Page<Emp>) empList;
  //   return new PageResult<Emp>(p.getTotal(),p.getResult());
  // }

  /**
   * 分页查询
   */
  @Override
  public PageResult<Emp> findByPage(EmpQueryParam empQueryParam) {
      // 设置pageHelper分页参数
      PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
      // 执行查询
      List<Emp> empList = empMapper.list(empQueryParam);

      // 解析查询结果，封装PageResult对象，返回
      Page<Emp> p = (Page<Emp>) empList;
      return new PageResult<Emp>(p.getTotal(),p.getResult());
  }

  /**
   * 新增员工
   */
  @Transactional(rollbackFor = Exception.class) // 开启事务,Transactional注解可以加在类上、接口上、方法上(推荐）
  @Override
  public void save(Emp emp) {
    try {
      // 保存员工的基本信息
      emp.setCreateTime(LocalDateTime.now());
      emp.setUpdateTime(LocalDateTime.now());
      empMapper.insert(emp);

      int i = 1/0;

      // 保存员工的工作经历
      List<EmpExpr> exprList = emp.getExprList();
      if(!CollectionUtils.isEmpty(exprList)) { // 如果工作经历不为空
        // 遍历集合
        exprList.forEach(expr -> {
          expr.setEmpId(emp.getId());
        });
        empExprMapper.insertBatch(exprList);
      }
    } finally {
      // 记录操作日志
      EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工:" + emp);
      empLogService.insertLog(empLog);
    }
  }
}

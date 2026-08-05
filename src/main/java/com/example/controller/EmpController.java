package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

  @Autowired
  private EmpService empService;


  // 分页查询
  @GetMapping
  public Result page(EmpQueryParam empQueryParam) {
    log.info("分页查询: {}", empQueryParam);
    PageResult<Emp> pageResult = empService.findByPage(empQueryParam);
    return Result.success(pageResult);
  }

  // 新增员工
  @PostMapping
  public Result save(@RequestBody Emp emp) {
    log.info("新增员工: {}", emp);
    empService.save(emp);
    return Result.success();
  }
}

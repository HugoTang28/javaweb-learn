package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

  @Autowired
  private EmpService empService;


  // 分页查询
  @GetMapping
  public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pagesize) {
    log.info("分页查询: {},{}", page, pagesize);
    PageResult<Emp> pageResult = empService.findByPage(page, pagesize);
    return Result.success(pageResult);
  }
}

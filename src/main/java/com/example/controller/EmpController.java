package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;


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

  // 删除员工
  // @DeleteMapping // 数组
  // public Result delete(Integer[] ids) {
  //   log.info("删除员工: {}", Arrays.toString(ids));
  //   // empService.delete(ids);
  //   return Result.success();
  // }

  // 集合
  @DeleteMapping
  public Result delete(@RequestParam List<Integer> ids) {
    log.info("删除员工: {}", ids);
    empService.delete(ids);
    return Result.success();
  }
}

package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/depts")
@Slf4j
public class DeptController {
  // private static final Logger log = LoggerFactory.getLogger(DeptController.class); //固定

  @Autowired
  private DeptService deptService;

  // @RequestMapping(value = "/depts", method = RequestMethod.GET)
  @GetMapping
  public Result list() {
    System.out.println("查询全部部门数据");
    List<Dept> deptList = deptService.findAll();
    return Result.success(deptList);
  }

  // 方式二
  // @DeleteMapping
  // public Result delete(@RequestParam("id") Integer deptid) { // RequestParam一旦声明  必须传值
  //   System.out.println("id: " + deptid);
  //   // System.out.println("删除部门数据");
  //   // deptService.delete(id);
  //   return Result.success();
  // }

  // 方式三
  @DeleteMapping
  // @RequestParam("id") 与 id相同的话 可以省略@RequestParam("id")
  public Result delete(Integer id) {
    log.info("删除部门{}数据", id);
    deptService.delete(id);
    return Result.success();
  }

  // 新增部门
  @PostMapping
  public Result add(@RequestBody Dept dept) {
    log.info("新增部门:{}",dept);
    deptService.add(dept);
    return Result.success();
  }

  // 根据id查询部门
  // @GetMapping("/depts/{id}")
  // public Result getId(@PathVariable("id") Integer id) {
  //   System.out.println("查询部门id数据"+ id);
  //   // deptService.findById(id);
  //   return Result.success();
  // }

  // 方式1上 方式2下

  @GetMapping("/{id}")
  public Result getId(@PathVariable Integer id) {
    log.info("查询部门id数据: {}",id);
    Dept dept =  deptService.findById(id);
    return Result.success(dept);
  }


  // 修改部门
  @PutMapping
  public Result update(@RequestBody Dept dept) {
    log.info("修改部门:{}", dept);
    deptService.update(dept);
    return Result.success();
  }
}

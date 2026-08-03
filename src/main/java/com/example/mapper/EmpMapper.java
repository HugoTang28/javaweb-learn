package com.example.mapper;


import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
  // ---------------------------------------原始分页查询方式------------------------------------------
  // /**
  //  * 统计总记录数
  //  * @return
  //  */
  // @Select("SELECT count(*) FROM emp e left join dept d on e.dept_id = d.id")
  // public Long count();
  //
  // /**
  //  * 分页查询
  //  * @return
  //  */
  // @Select("SELECT e.*, d.name deptName FROM emp e left join dept d on e.dept_id = d.id " +
  //     "order by e.update_time desc limit #{start},#{pagesize};")
  // public List<Emp> list(@Param("start") Integer start, @Param("pagesize") Integer pagesize);

  // =-----------------------------------采用pageHelper分页查询------------------------------------
  // 注意：sql语句不能加分号、
  @Select("SELECT e.*, d.name deptName FROM emp e left join dept d on e.dept_id = d.id " +
      "order by e.update_time desc")
  public List<Emp> list();
}

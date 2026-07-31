package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
  /**
   * 查询全部部门数据
   */
  @Select("select ID, NAME, CREATE_TIME, UPDATE_TIME from dept ORDER BY update_time desc")
  List<Dept> findAll();

  /**
   * 删除部门数据
   * @param id
   */
  @Delete("delete from dept where id = #{id}")
  void delete(Integer id);

  /**
   * 新增部门
   * @param dept
   */
  @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
  void add(Dept dept);

  /**
   * 根据id查询部门
   * @param id
   * @return
   */
  @Select("select * from dept where id = #{id}")
  Dept findById(Integer id);

  @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
  void updateDept(Dept dept);
}

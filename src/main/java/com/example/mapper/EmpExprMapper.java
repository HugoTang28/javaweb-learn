package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作经历
 */
@Mapper
public interface EmpExprMapper {
  /**
   * 批量保存员工的工作经历信息
   * @param exprList
   */
  void insertBatch(@Param("exprList") List<EmpExpr> exprList);

  // 批量删除员工工作经历信息
  void deleteByEmpIds(@Param("ids") List<Integer> ids);
}

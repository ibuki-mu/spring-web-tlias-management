package com.ibuki.mapper;

import com.ibuki.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void addEmpExpr(List<EmpExpr> exprList);
}

package com.ibuki.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ibuki.mapper.EmpExprMapper;
import com.ibuki.mapper.EmpMapper;
import com.ibuki.pojo.Emp;
import com.ibuki.pojo.EmpExpr;
import com.ibuki.pojo.PageResult;
import com.ibuki.service.EmpExprService;
import com.ibuki.service.EmpService;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    /*
     * 分页查询员工信息
     * @param page 当前页码
     * @param pageSize 每页显示的记录数
     * */
//---------------------原始方法分页查询员工信息-------------------------
//    @Override
//    public PageResult<Emp> findEmpsPage(int page, int pageSize) {
//        int empsPageSize = empMapper.getEmpsPageSize();
//
//        List<Emp> empsPage = empMapper.getEmpsPage((page - 1) * pageSize, pageSize);
//
//        return new PageResult<Emp>(empsPageSize,empsPage);
//    }

//    @Override
//    public List<Emp> findAllEmps() {
//        return empMapper.getAllEmps();
//    }

    //---------------------使用PageHelper分页查询员工信息-------------------------
    @Override
    public PageResult<Emp> findEmpsPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Emp> empsPage = empMapper.getEmpsPage();

        Page<Emp> p = (Page<Emp>) empsPage;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);

        List<EmpExpr>exprList = emp.getExprList();
        if (!exprList.isEmpty()){
            for (EmpExpr empExpr : exprList) {
                empExpr.setEmpId(emp.getId());
            }
            empExprMapper.addEmpExpr(exprList);
        }
    }
}

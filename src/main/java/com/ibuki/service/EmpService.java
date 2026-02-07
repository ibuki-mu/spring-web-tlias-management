package com.ibuki.service;

import com.ibuki.pojo.Emp;
import com.ibuki.pojo.PageResult;

public interface EmpService {
//    public List<Emp> findAllEmps();

    /*
    * 分页查询员工信息
    * */
    PageResult<Emp> findEmpsPage(int page, int pageSize);

    void addEmp(Emp emp);
}

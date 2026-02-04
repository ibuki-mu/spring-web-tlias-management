package com.ibuki.mapper;


import com.ibuki.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
//    // 查询所有员工信息
//    @Select("select emp.* , dept.name from emp left join dept on dept.id = emp.dept_id;")
//    public List<Emp> getAllEmps();

    /*
     * 查询符合查询条件的总员工数量
     * */
    @Select("select count(*) from emp")
    public int getEmpsPageSize();

    /*
     * 分页查询员工信息
     * */
    @Select("select emp.*, dept.name deptName from emp left join dept on dept.id = emp.dept_id limit #{start},#{pageSize}")
    public List<Emp> getEmpsPage(int start, int pageSize);
}

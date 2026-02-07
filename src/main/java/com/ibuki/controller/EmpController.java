package com.ibuki.controller;

import com.ibuki.pojo.Emp;
import com.ibuki.pojo.PageResult;
import com.ibuki.pojo.Result;
import com.ibuki.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

//    // 获取所有员工信息
//    @GetMapping
//    public Result getAllEmps(){
//        log.info("获取所有员工信息");
//        List<Emp> allEmps = empService.findAllEmps();
//        return Result.success(allEmps);
//    }

    /*
    * 分页查询员工信息
    * */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int pageSize) {
        log.info("获取分页数据，page：{}，pageSize：{}", page, pageSize);
        PageResult<Emp> pageResult = empService.findEmpsPage(page, pageSize);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("添加员工信息：{}", emp);

        empService.addEmp(emp);

        return Result.success();
    }
}

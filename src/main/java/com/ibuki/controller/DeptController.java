package com.ibuki.controller;

import com.ibuki.pojo.Dept;
import com.ibuki.pojo.Result;
import com.ibuki.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        System.out.println("查询所有部门");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }

    @DeleteMapping("/depts")
    public Result deleteResult(@RequestParam(value = "id",required = false)int id) {
//        int deleted = deptService.deleteResult(id);
        System.out.println("删除部门" + id + "成功");
        return Result.success();
    }
}

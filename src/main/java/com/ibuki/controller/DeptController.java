package com.ibuki.controller;

import com.ibuki.pojo.Dept;
import com.ibuki.pojo.Result;
import com.ibuki.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")

public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
        System.out.println("查询所有部门");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }

    @DeleteMapping("/{id}")
    public Result deleteResultByPath(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            log.warn("删除部门失败，id参数无效: " + id);
            return Result.error("参数不能为空或无效");
        }
        int deleted = deptService.deleteResult(id);
//        System.out.println("删除部门" + id + "成功");
        log.info("删除部门" + id + "成功");
        log.info("影响了" + deleted + "行");
        return Result.success();
    }
    
    @DeleteMapping
    public Result deleteResultByParam(@RequestParam Integer id) {
        if (id == null || id <= 0) {
            log.warn("删除部门失败，id参数无效: " + id);
            return Result.error("参数不能为空或无效");
        }
        int deleted = deptService.deleteResult(id);
//        System.out.println("删除部门" + id + "成功");
        log.info("删除部门" + id + "成功");
        log.info("影响了" + deleted + "行");
        return Result.success();
    }
}

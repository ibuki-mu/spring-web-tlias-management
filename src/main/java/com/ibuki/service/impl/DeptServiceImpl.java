package com.ibuki.service.impl;

import com.ibuki.mapper.DeptMapper;
import com.ibuki.pojo.Dept;
import com.ibuki.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAllDeptByUpdatetime();
    }

    @Override
    public int deleteResult(int id) {
        return 0;
    }
}

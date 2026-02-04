package com.ibuki.service;


import com.ibuki.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    int deleteResult(Integer id);
}

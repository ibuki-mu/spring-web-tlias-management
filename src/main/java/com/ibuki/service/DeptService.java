package com.ibuki.service;


import com.ibuki.pojo.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> findAll();

    public int deleteResult(int id);
}

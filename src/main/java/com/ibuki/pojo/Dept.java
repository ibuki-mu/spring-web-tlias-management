package com.ibuki.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/*
* 部门信息表
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private int id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

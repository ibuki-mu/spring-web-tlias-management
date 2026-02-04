package com.ibuki.pojo;

import lombok.Data;

/**
 * 后端统一返回结果
 */
@Data
public class Result {

    private int code; //编码：1成功，0为失败
    private String msg; //错误信息
    private Object data; //数据

    //成功，不返回数据
    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    //成功，并返回从数据库获取的数据
    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }
    //失败，返回错误信息
    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}

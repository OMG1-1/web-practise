package com.kzy.controller;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/12
 * @time 14:20
 * @note ……
 */
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public Result(Object data, Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

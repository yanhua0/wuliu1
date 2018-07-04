package org.wuliu.utils;


import org.wuliu.enums.ResultEnum;

public class Result<T> {


    private Integer code;


    private String msg;

    private T data;

    public T getDate() {
        return data;
    }

    public void setDate(T date) {
        this.data = date;
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

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

}

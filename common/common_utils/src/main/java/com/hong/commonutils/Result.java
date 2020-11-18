package com.hong.commonutils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private boolean success;
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<String,Object>();
    //构造函数私有化，只能调用静态方法ok()、error()
    private Result(){}

    //链式编程
    //ok方法中创建了对象
    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功");
        return result;
    }
    public static Result error(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.Error);
        result.setMessage("失败");
        return result;
    }
    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public Result message(String message){
        this.setMessage(message);
        return this;
    }
    public Result code(Integer code){
        this.setCode(code);
        return this;
    }
    public Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}

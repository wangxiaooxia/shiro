package com.qianfeng.shiro.data;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultData {
    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有
    private ResultData() {}

    //成功静态方法
    public static ResultData ok() {
        ResultData r = new ResultData();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static ResultData error() {
        ResultData r = new ResultData();
        r.setSuccess(false);
        r.setCode(20002);
        r.setMessage("失败");
        return r;
    }

    public ResultData success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultData message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultData code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultData data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultData data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}

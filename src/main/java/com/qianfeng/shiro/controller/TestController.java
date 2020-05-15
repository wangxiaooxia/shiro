package com.qianfeng.shiro.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
    @GetMapping("hello")
    @SentinelResource(value = "test.hello",fallback = "helloError")
    public String hello(String name){
        return "hello:"+name;
    }
    public String helloError(String name){
        return "error:"+name;
    }
}

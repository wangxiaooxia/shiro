package com.qianfeng.shiro.controller;

import com.qianfeng.shiro.data.ResultData;
import com.qianfeng.shiro.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;
    //添加redis队列
    @GetMapping("/testAddDL")
    public ResultData testAddDL(){
        redisService.addDL();
        return ResultData.ok();
    }
    //移除redis队列
    @GetMapping("/testRemoveDL")
    public ResultData testRemoveDL(){
        redisService.removeDL();
        return ResultData.ok();
    }
}

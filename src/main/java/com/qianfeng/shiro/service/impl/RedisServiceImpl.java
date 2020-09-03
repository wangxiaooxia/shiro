package com.qianfeng.shiro.service.impl;

import com.alibaba.fastjson.JSON;
import com.qianfeng.shiro.entity.AclUser;
import com.qianfeng.shiro.service.RedisService;
import com.qianfeng.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;
    @Override
    public void addDL() {
        AclUser aclUser = new AclUser();
        aclUser.setGmtCreate(new Date());
        aclUser.setGmtModified(new Date());
        aclUser.setNickname("Test");
        aclUser.setUsername("wxx");

        redisTemplate.opsForList().leftPush("Test", JSON.toJSONString(aclUser));
    }

    @Override
    public void removeDL() {
        redisTemplate.opsForList().rightPop("Test");
        redisTemplate.opsForList();
    }

}

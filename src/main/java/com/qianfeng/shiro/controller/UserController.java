package com.qianfeng.shiro.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.qianfeng.shiro.data.ResultData;
import com.qianfeng.shiro.entity.AclUser;
import com.qianfeng.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
        @GetMapping("/sel/{id}")
    @SentinelResource(value = "sel",blockHandler = "findAll")
    public AclUser sel(@PathVariable int id){
        AclUser user = userService.Sel(id);
        return user;
    }
    @GetMapping("/findAll")
    @SentinelResource(value = "findAll",blockHandler = "sel")
    public ResultData findAll(){
        List<AclUser> list = userService.findAll();
        return  ResultData.ok().data("field",list);
    }

    @GetMapping("/findRoleByUserId/{id}")
    public ResultData findRoleByUserId(@PathVariable int id){
        AclUser aclUser = userService.oneToManyByUser(id);
        try{
            System.out.println(aclUser.getRoleList().size());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  ResultData.ok().data("field",aclUser);
    }
}


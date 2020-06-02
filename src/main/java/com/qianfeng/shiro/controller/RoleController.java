package com.qianfeng.shiro.controller;

import com.qianfeng.shiro.data.ResultData;
import com.qianfeng.shiro.entity.AclUserRole;
import com.qianfeng.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @GetMapping("/findRole")
    public ResultData findRole(){
        List<AclUserRole> roles = roleService.getRoles();
        return ResultData.ok().data("field",roles);
    }


}

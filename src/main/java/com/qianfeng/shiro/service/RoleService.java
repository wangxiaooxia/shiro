package com.qianfeng.shiro.service;

import com.qianfeng.shiro.entity.AclUserRole;
import com.qianfeng.shiro.mapper.RoleMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapping roleMapping;

    public List<AclUserRole> getRoles (){
        return  roleMapping.getRoles();
    }
}

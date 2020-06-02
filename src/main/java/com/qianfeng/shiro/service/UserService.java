package com.qianfeng.shiro.service;

import com.qianfeng.shiro.entity.AclUser;
import com.qianfeng.shiro.mapper.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    @Autowired
    private UserMapping userMapper;

    public AclUser Sel(int id){
       return  userMapper.Sel(id);
    }

    public List<AclUser> findAll() {
        return userMapper.findAll();
    }
    public AclUser oneToManyByUser(int id){
        return userMapper.oneToManyByUser(id);
    }

}

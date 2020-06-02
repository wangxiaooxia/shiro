package com.qianfeng.shiro.mapper;

import com.qianfeng.shiro.entity.AclUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapping {
    AclUser Sel(int id);
    List<AclUser> findAll();
    AclUser oneToManyByUser(int id);
}

package com.qianfeng.shiro.mapper;

import com.qianfeng.shiro.entity.AclUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapping {
    List<AclUserRole> getRoles();
}

package com.qianfeng.shiro.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AclUserRole  {

    private String id;
    private String roleId;
    private String userId;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}

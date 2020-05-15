package com.qianfeng.shiro.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AclUser {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String salt;
    private String token;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;

}

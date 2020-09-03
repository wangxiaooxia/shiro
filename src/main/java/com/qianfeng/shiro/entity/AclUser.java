package com.qianfeng.shiro.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document("acl_user" )
public class AclUser {
    @Id
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String salt;
    private String token;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;

    private List<AclUserRole>  roleList;

}

package com.qianfeng.shiro.netty.protocoltcp;

import lombok.Data;

@Data
public class MessageProtocol {
    private int len;
    private byte[] content;

}

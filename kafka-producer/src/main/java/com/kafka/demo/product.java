package com.kafka.demo;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class product {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String name){
        User u=new User();
        u.setName(name);
        u.setAge(11);
        kafkaTemplate.send("user-log-group", JSON.toJSONString(u));
    }
}
@Data
class User {
    private String name;
    private int age;
}
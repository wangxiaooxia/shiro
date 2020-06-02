package com.qianfeng.shiro.controller;

import com.mongodb.client.result.UpdateResult;
import com.qianfeng.shiro.data.ResultData;
import com.qianfeng.shiro.entity.AclUser;
import com.qianfeng.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongodb")
public class MongoDbController {

    @Autowired
    private UserService userService;
    @Autowired
    private MongoTemplate mongoTemplate;

    //创建mongodb的数据库
    @GetMapping("/testAddMongo")
    public void testAddMongo(){
        mongoTemplate.createCollection("test");
    }

    //查询所有数据
    @GetMapping("/findData")
   public ResultData testShowData(){
        List<AclUser> list =  mongoTemplate.findAll(AclUser.class,"acluser");
        if (list.size() > 0 ){
            list.forEach(user -> {
              System.out.println("user.get = " + user.getNickname());
            });
        }
    return ResultData.ok().data("field",list);
   }
   //模糊查询根据name
   @GetMapping(value = "/findByName/{name}")
    public ResultData findByName(@PathVariable String name){
        Criteria criteria = Criteria.where("username").is(name);
        Query query = new Query(criteria);
       List<AclUser> list = mongoTemplate.find(query,AclUser.class,"acluser");
       return ResultData.ok().data("field",list);
    }
    //根据id删除数据
    @GetMapping("/deleteById/{id}")
    public ResultData deleteById(@PathVariable int id){
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.findAndRemove(query,AclUser.class,"acluser");

        return ResultData.ok();
    }
    //根据id更新数据信息
    @GetMapping("/updateById/{id}")
    public  ResultData updateById (@PathVariable int id ){
        Criteria criteria = Criteria.where("id").is(id);
        Update update = new Update();
        update.set("username","admin123").set("nickname","admin123");
        Query query = new Query(criteria);

        UpdateResult wr = mongoTemplate.updateFirst(query,update,AclUser.class,"acluser");
        System.out.println("wr.getMatchedCount() = " + wr.getMatchedCount());
        return  ResultData.ok().data("flag", wr.getMatchedCount());
    }
   //mongodb 插入数据
   @GetMapping("/testInsert")
   public void testInsert(){
       List<AclUser> userList = userService.findAll();
       userList.forEach(user ->{
           mongoTemplate.insert(user);
       });
   }
   //删除集合
   @GetMapping("/testDropCollection")
   public void testDropCollection(){
       mongoTemplate.dropCollection("test");
   }
}

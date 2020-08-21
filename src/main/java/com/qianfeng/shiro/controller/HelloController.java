package com.qianfeng.shiro.controller;

import com.qianfeng.shiro.entity.AclUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello/{name}")
    //public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
    public String hello(Model model, @PathVariable String name) {
        model.addAttribute("name",name);
        List<AclUser> list = new ArrayList<AclUser>();
        AclUser aclUser = null;
        for (int i = 0; i < 3; i++) {
            aclUser = new AclUser();
            aclUser.setNickname("name"+i);
            aclUser.setGmtCreate(new Date());
            list.add(aclUser);
        }
        model.addAttribute("test",18);
        model.addAttribute("sex",0);
        model.addAttribute("data",list);
        //request.setAttribute("name", name);
        return "aaTest";
    }

}

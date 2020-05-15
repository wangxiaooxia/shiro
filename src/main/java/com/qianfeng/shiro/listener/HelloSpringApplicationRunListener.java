package com.qianfeng.shiro.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    public HelloSpringApplicationRunListener(SpringApplication application,String args[]){

    }

    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener----starting-");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("SpringApplicationRunListener----"+environment.getSystemProperties().get("os.name"));
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener----"+context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener ---contextLoaded-");
    }

//    @Override
//    public void finished(ConfigurableApplicationContext context, Throwable exception) {
//        System.out.println("SpringApplicationRunListener----finished-");
//    }
}

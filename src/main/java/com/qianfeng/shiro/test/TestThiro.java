/*
//package com.qianfeng.shiro.test;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.config.IniSecurityManagerFactory;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.util.Factory;
//
//public class TestThiro {
//    public static void main(String[] args) {
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token =  new UsernamePasswordToken("lisi","456");
//        System.out.println(subject.isAuthenticated());
//
//        subject.login(token);
//        System.out.println(subject.isAuthenticated());
//
//        System.out.println(subject.getPrincipal());
//        //角色校验
//        boolean isAamin = subject.hasRole("admin");
//
//        System.out.println(isAamin);
//
//        //权限校验
//        System.out.println(subject.isPermitted("a:b")); ;
//        System.out.println(subject.isPermitted("user:insert"));
//
//        subject.logout();
//
//    }
//}
*/

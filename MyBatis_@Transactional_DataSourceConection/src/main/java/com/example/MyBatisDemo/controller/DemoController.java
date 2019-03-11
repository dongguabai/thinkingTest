package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongguabai
 * @date 2019-03-11 21:11
 */

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public Object test(Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping("/test1Cache")
    public Object test1Cache(Integer id){
        userService.test1Cache(id);
        return "OK";
    }
}

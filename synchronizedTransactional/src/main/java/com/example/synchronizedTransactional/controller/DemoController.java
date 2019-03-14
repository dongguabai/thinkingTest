package com.example.synchronizedTransactional.controller;

import com.example.synchronizedTransactional.service.UserService;
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

    @RequestMapping("/")
    public Object test() {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                userService.updateUser();
            }).start();
        }
        return "success";
    }


    @RequestMapping("/zhihu")
    public Object test2() {
        for (int i = 0; i < 100; i++) {
            /*  try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            new Thread(()->{
                userService.updateUserZhiHu();
            }).start();
        }
        return "success";
    }

}

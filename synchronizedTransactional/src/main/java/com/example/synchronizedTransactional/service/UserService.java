package com.example.synchronizedTransactional.service;

import com.example.synchronizedTransactional.dao.UserMapper;
import com.example.synchronizedTransactional.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dongguabai
 * @date 2019-03-11 21:40
 */
@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;

    /**
     * 这个方法是线程安全的
     * @return
     */
   @Transactional
    public Integer updateUser(){
        Integer integer = userMapper.updateUser();
        System.out.println("【"+Thread.currentThread().getName()+"】执行结果（"+integer+"）");
        return integer;
    }


    @Transactional
    public Integer updateUserZhiHu(){
        User user = userMapper.selectByPrimaryKey(1);
        long balance = user.getBalance();
        System.out.println("【"+Thread.currentThread().getName()+"】查询出来的用户余额为（"+balance+"）");
        Integer integer = userMapper.updateUserZhiHu(balance-10);
        return integer;
    }



}

package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.dao.UserMapper;
import com.example.MyBatisDemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongguabai
 * @date 2019-03-11 21:40
 */
@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;
   //@Transactional
    public User getUserById(Integer id){
        userMapper.selectByPrimaryKey(id);
        System.out.println("------------------");
        userMapper.selectByPrimaryKey(3);
        System.out.println("====================");
        return userMapper.selectByPrimaryKey(4);
    }
}

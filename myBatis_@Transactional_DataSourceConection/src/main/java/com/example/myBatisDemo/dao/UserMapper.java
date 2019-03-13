package com.example.myBatisDemo.dao;

import com.example.myBatisDemo.entity.User;

/**
 * @author dongguabai
 * @date 2019-03-11 21:26
 */
public interface UserMapper {

    User selectByPrimaryKey(Integer id);
}

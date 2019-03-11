package com.example.MyBatisDemo.dao;

import com.example.MyBatisDemo.entity.User;

/**
 * @author dongguabai
 * @date 2019-03-11 21:26
 */
public interface UserMapper {

    User selectByPrimaryKey(Integer id);
}

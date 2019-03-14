package com.example.synchronizedTransactional.dao;

import com.example.synchronizedTransactional.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongguabai
 * @date 2019-03-11 21:26
 */
public interface UserMapper {

    Integer updateUser();

    User selectByPrimaryKey(Integer id);

    Integer updateUserZhiHu(@Param("balance") long balance);
}

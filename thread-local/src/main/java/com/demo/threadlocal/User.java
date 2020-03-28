package com.demo.threadlocal;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-28 15:19
 */
@Data
public class User {

    private String name;

    private Date birthday;

    private List<String> addresses;
}

package com.example.MyBatisDemo.entity;

/**
 * @author dongguabai
 * @date 2019-03-11 21:28
 */
public class User {

    private Integer id;

    private String username;

    private long balance;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}

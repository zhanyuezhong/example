package com.zyz.designpattern;

/**
 * User: 张月忠
 * Date: 2017/8/18
 * Time: 下午1:28
 * To change this template use File | Settings | File Templates.
 */

public class User{
    private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}

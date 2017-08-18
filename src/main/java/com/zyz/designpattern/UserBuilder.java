package com.zyz.designpattern;


/**
 * User: 张月忠
 * Date: 2017/8/18
 * Time: 下午1:29
 * To change this template use File | Settings | File Templates.
 */

public class UserBuilder {
    private Integer userId;
    private String userName;

    public UserBuilder userName(String userName){
        this.userName =userName;
        return this;
    }

    public UserBuilder userId(Integer userId){
        this.userId =userId;
        return this;
    }


    User builder(){
        return new User(userId,userName);
    }

    public static void main(String[] args){


    }
}

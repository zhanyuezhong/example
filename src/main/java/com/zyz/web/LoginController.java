package com.zyz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: 张月忠
 * Date: 2017/8/1
 * Time: 下午2:39
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public String login(){
        System.out.println("login no param");
        return "/asdfasdf";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String login(String username){
        System.out.println("login with username:"+username);
        return "ewrwer";
    }
}

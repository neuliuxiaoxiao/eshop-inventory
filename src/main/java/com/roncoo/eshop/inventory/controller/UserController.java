package com.roncoo.eshop.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.eshop.inventory.model.User;
import com.roncoo.eshop.inventory.service.UserService;

@Controller
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getCacheUser();
        return user;
    }

}

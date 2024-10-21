package com.atguigu.cloud.user.controller;

import com.atguigu.cloud.user.entity.User;
import com.atguigu.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable("userId") Long userId){
        return userService.getById(userId);
    }
}

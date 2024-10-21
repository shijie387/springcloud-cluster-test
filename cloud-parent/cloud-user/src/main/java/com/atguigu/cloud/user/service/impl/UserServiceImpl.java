package com.atguigu.cloud.user.service.impl;

import com.atguigu.cloud.user.entity.User;
import com.atguigu.cloud.user.mapper.UserMapper;
import com.atguigu.cloud.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

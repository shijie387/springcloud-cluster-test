package com.atguigu.cloud.order.service.impl;

import com.atguigu.cloud.order.entity.Order;
import com.atguigu.cloud.order.feign.UserFeignClient;
import com.atguigu.cloud.order.mapper.OrderMapper;
import com.atguigu.cloud.order.service.OrderService;
import com.atguigu.cloud.user.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

//    @Autowired
//    private RestTemplate restTemplate ;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order findOrderByOrderId(Long orderId) {

        Order order = baseMapper.selectById(orderId);
        Long userId = order.getUserId();

        //传统方式的远程调用（Spring）
//        User user = restTemplate.getForObject("http://cloud-user/api/user/findUserByUserId/" + userId, User.class);

        User user = userFeignClient.queryById(userId);
        order.setUser(user);
        return order;
    }
}
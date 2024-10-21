package com.atguigu.cloud.order.service;

import com.atguigu.cloud.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Order> {
    Order findOrderByOrderId(Long orderId);
}
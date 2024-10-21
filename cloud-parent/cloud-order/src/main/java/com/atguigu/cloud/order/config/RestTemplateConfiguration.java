package com.atguigu.cloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    //微服务的远程调用
    @Bean
    //让RestTemplate具有负载均衡的功能
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

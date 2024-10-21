package com.atguigu.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

@Component
public class AuthorizationFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求中的"username"参数值
        String username = exchange.getRequest().getQueryParams().getFirst("username");

        //判断username是否为空
        if(!StringUtils.hasText(username)){
            //如果为空，则设置响应状态码为HttpStatus.UNAUTHORIZED（未经授权），
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();//表示请求处理完成
        }
        return chain.filter(exchange);//将请求传递给下一个过滤器
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

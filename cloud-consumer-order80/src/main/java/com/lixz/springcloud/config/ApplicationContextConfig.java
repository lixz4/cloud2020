package com.lixz.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lixz
 * @date 2020/4/27 - 14:29
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力，如果没有这个注解，httpclient调用是不能识别Eureka注册的服务名的url
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

package com.lixz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lixz
 * @date 2020/5/3 - 17:30
 */
@SpringBootApplication
@EnableEurekaServer //表示是Eureka服务注册中心server端
/**
 * Eureka 单机版部署
 */
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}

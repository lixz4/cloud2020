package com.lixz.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类为配置ribbon负载均衡规则类，默认为轮询访问
 * 官方文档给出明确警告：这个自定义配置类不能放在@ComponentScan所扫描的当前包以及子包下
 * (@ComponentScan注解在@SpringBootApplication注解中定义，扫描范围是增加@SpringBootApplication注解的类所在的包及子包)
 * 否则我们定义这个配置类就会被所有的ribbon客户端所共享，达不到特殊化定制的目的
 * 所以要新建一个和com.lixz.springcloud包同级的包来写该配置文件
 * @author lixz
 * @date 2020/6/29 - 13:52
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();    //定义为随机
    }
}

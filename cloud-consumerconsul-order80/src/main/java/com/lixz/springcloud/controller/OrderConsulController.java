package com.lixz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lixz
 * @date 2020/5/8 - 17:35
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);    //参数：url, 返回值类型
        return result;
    }
}

package com.lixz.springcloud.controller;

import com.lixz.springcloud.entities.CommonResult;
import com.lixz.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lixz
 * @date 2020/4/27 - 14:24
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;  //内部封装一系列httpClient方法

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        //发送http的post请求，参数为url,发送的内容，返回的class
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        //发送http的get请求，参数为url，返回的class
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}

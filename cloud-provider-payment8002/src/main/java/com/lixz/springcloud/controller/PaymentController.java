package com.lixz.springcloud.controller;

import com.lixz.springcloud.entities.CommonResult;
import com.lixz.springcloud.entities.Payment;
import com.lixz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lixz
 * @date 2020/4/26 - 18:08
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create") //接收post请求
    public CommonResult create(@RequestBody Payment payment){  //不加@RequestBody注解，无法获取get请求传入的参数,加了以后报错，暂未找到解决办法
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if(result > 0){
            return new CommonResult(200, "插入数据库成功, serverPort:" + serverPort, result);
        }else{
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")    //接收get请求
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("******查询结果：" + result);
        if(result != null){
            return new CommonResult(200, "查询成功, serverPort:" + serverPort, result);
        }else{
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }
}

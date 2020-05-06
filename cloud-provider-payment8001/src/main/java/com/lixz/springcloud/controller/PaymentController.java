package com.lixz.springcloud.controller;

import com.lixz.springcloud.entities.CommonResult;
import com.lixz.springcloud.entities.Payment;
import com.lixz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lixz
 * @date 2020/4/26 - 18:08
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;    //对于注册进Eureka里面的微服务，可以通过服务发现来获得该服务的信息

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

    @GetMapping(value = ("/payment/discovery"))
    public Object discovery(){
        List<String> services =  discoveryClient.getServices();     //获取注册进Eureka中的服务名称
        for(String element : services){
            log.info("*******element:" + element);
        }

        //获取该服务名称对应的实例化
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");    //参数：服务名称
        for(ServiceInstance instance : instances){
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}

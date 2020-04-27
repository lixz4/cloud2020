package com.lixz.springcloud.service;

import com.lixz.springcloud.entities.Payment;

/**
 * @author lixz
 * @date 2020/4/26 - 18:03
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}

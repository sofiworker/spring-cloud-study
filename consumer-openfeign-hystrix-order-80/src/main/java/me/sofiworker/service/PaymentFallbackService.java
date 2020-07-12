package me.sofiworker.service;

import org.springframework.stereotype.Service;

/**
 * @author sofiworker
 * @date 2020/7/11  18:09
 */
@Service
public class PaymentFallbackService implements HystrixPaymentService {

    @Override
    public String paymentOk() {
        return "paymentOk------客户端80在openfegin的统一服务降级";
    }

    @Override
    public String paymentError() {
        return "paymentError------客户端80在openfegin的统一服务降级";
    }
}

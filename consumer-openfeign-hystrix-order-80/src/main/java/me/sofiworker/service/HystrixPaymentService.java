package me.sofiworker.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sofiworker
 * @date 2020/7/11  16:55
 */
@Service
@FeignClient(value = "provider-hystrix-payment:8001", fallback = PaymentFallbackService.class)
public interface HystrixPaymentService {

    @GetMapping("/payment/hystrix/ok")
    String paymentOk();

    @GetMapping("/payment/hystrix/error")
    String paymentError();
}


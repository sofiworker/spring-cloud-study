package me.sofiworker.service;

import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sofiworker
 * @date 2020/7/11  11:55
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/openfeign/timeout")
    String testOpenfeignTimeout();
}

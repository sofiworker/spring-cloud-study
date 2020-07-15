package me.sofiworker.service;

import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sofiworker
 * @date 2020/7/15  22:18
 */
@FeignClient(value = "payment-service", fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}

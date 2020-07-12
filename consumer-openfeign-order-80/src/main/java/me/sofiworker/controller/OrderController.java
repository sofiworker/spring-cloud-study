package me.sofiworker.controller;

import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import me.sofiworker.service.PaymentFeignService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author sofiworker
 * @date 2020/7/11  11:59
 */
@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/openfeign/timeout")
    public String testOpenfeignTimeout() {
        return paymentFeignService.testOpenfeignTimeout();
    }
}

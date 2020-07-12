package me.sofiworker.controller;

import me.sofiworker.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sofiworker
 * @date 2020/7/11  16:17
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @GetMapping("/payment/hystrix/ok")
    public String paymentOk() {
        return "当前端口号："+port+"，结果："+paymentService.paymentInfoOk();
    }

    @GetMapping("/payment/hystrix/error")
    public String paymentError() {
        return "当前端口号："+port+"，结果："+paymentService.paymentInfoError();
    }

    @GetMapping("/payment/hystrix/circuit/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable Long id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}

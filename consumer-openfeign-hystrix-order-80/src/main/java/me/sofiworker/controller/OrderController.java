package me.sofiworker.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import me.sofiworker.service.HystrixPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sofiworker
 * @date 2020/7/11  16:57
 */
@RestController
@DefaultProperties(defaultFallback = "globalPaymentInfoHandler")
public class OrderController {

    @Resource
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/consumer/ok")
    public String paymentOk() {
        return hystrixPaymentService.paymentOk();
    }

    @GetMapping("/consumer/error")
    public String paymentError() {
        return hystrixPaymentService.paymentError();
    }

    @GetMapping("/consumer/hystrix/error")
    @HystrixCommand(fallbackMethod = "paymentInfoErrorHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hystrixPaymentError() {
        return hystrixPaymentService.paymentError();
    }

    public String paymentInfoErrorHandler() {
        return "80错误处理";
    }

    @HystrixCommand
    @GetMapping("/consumer/global/hystrix/error")
    public String globalHystrixPaymentError() {
        return hystrixPaymentService.paymentError();
    }

    public String globalPaymentInfoHandler() {
        return "这是80的全局服务降级处理";
    }
}

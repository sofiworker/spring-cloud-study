package me.sofiworker.controller;

import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import me.sofiworker.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/3 18:24
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功", result);
        }else {
            return new CommonResult<>(400, "插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功，服务端口号为："+port, payment);
        }else {
            return new CommonResult<>(400, "查询失败");
        }
    }

    @GetMapping("/service/info")
    public List<String> serviceInfo(){
        return discoveryClient.getServices();
    }
}

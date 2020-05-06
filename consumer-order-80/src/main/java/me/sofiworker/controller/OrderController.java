package me.sofiworker.controller;

import lombok.extern.slf4j.Slf4j;
import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/3 22:55
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String URL = "http://localhost:8001";
    public static final String URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return restTemplate.getForObject(URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/service/info")
    public Object getServiceInfo(){
        return restTemplate.getForObject(URL+"/service/info", List.class);
    }
}

package me.sofiworker.controller;

import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import me.sofiworker.lb.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/3 22:55
 */
@RestController
public class OrderController {
    public static final String URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private MyLoadBalancer myLoadBalancer;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        ServiceInstance instance = myLoadBalancer.lb(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/get/"+id, CommonResult.class);
//        return restTemplate.getForObject(URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/service/info")
    public Object getServiceInfo(){
        return restTemplate.getForObject(URL+"/service/info", List.class);
    }
}

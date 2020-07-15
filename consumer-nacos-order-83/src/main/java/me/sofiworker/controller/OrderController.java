package me.sofiworker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sofiworker
 * @date 2020/7/13  17:28
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String SERVER_URL = "http://payment-provider";

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable Long id) {
        return restTemplate.getForObject(SERVER_URL+"/nacos/"+id, String.class);
    }
}

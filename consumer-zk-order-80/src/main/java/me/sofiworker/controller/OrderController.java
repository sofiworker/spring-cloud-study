package me.sofiworker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/8 10:22
 */
@RestController
public class OrderController {
    public static final String URL = "http://payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(URL + "/zk", String.class);
    }

}

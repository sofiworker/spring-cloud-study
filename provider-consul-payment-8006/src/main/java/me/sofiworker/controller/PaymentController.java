package me.sofiworker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sofiworker
 * @date 2020/7/10  17:18
 */
@RestController
public class PaymentController {

    @GetMapping("/consul/port")
    public String getPort() {
        return "Consul 的 port 为：8006";
    }
}

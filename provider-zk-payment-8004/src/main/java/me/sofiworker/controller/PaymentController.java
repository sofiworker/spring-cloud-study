package me.sofiworker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/8 9:49
 */
@RestController
public class PaymentController {

    @GetMapping("/zk")
    public String getPort(){
        return "zk的端口是2181";
    }
}

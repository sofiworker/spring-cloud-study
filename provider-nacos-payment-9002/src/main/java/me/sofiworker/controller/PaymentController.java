package me.sofiworker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sofiworker
 * @date 2020/7/13  17:14
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/{id}")
    public String getMes(@PathVariable Long id) {
        return "已将端口号为："+port+"，注册进入nacos，当前你传入的id为："+id;
    }
}

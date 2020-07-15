package me.sofiworker.controller;

import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author sofiworker
 * @date 2020/7/15  21:14
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "1111111111111111111"));
        hashMap.put(2L, new Payment(2L, "2222222222222222222"));
        hashMap.put(3L, new Payment(3L, "3333333333333333333"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200, "来自端口号为："+port+"的服务", payment);
    }
}

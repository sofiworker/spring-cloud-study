package me.sofiworker.service;

import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author sofiworker
 * @date 2020/7/15  22:21
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444, "feign 中服务降级返回", new Payment(id, "errorSerial"));
    }
}

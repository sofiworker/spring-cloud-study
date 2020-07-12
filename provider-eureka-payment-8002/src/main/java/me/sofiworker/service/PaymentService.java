package me.sofiworker.service;

import me.sofiworker.entities.Payment;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/3 18:20
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}

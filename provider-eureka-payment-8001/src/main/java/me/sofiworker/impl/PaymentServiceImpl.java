package me.sofiworker.impl;

import me.sofiworker.dao.PaymentDao;
import me.sofiworker.entities.Payment;
import me.sofiworker.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/3 18:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

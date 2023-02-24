package com.xiong.service.impl;

import com.xiong.entity.Payment;
import com.xiong.mapper.PaymentMappper;
import com.xiong.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMappper paymentMappper;


    @Override
    public int create(Payment payment) {
        return paymentMappper.create(payment);
    }

    @Override
    public Payment querrybyId(Long id) {
        return paymentMappper.querrybyId(id);
    }
}

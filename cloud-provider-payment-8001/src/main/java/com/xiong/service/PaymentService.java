package com.xiong.service;

import com.xiong.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment querrybyId(@Param("id") Long id);
}

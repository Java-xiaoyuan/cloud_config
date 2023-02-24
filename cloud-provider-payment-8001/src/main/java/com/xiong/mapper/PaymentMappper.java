package com.xiong.mapper;

import com.xiong.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMappper {
    public int create(Payment payment);

    public Payment querrybyId(@Param("id") Long id);
}

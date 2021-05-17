package com.java.springcloud.service;

import com.java.springcloud.entity.Payment;
import com.java.springcloud.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public Payment getById(Integer id) {
        return paymentMapper.getById(id);
    }
}

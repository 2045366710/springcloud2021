package com.java.springcloud.service;

import com.java.springcloud.entities.Payment;

public interface PaymentService {

    Payment getById(Integer id);
}

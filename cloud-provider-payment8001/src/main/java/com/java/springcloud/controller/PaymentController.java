package com.java.springcloud.controller;

import com.java.springcloud.entity.Payment;
import com.java.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("get/{id}")
    public Payment getById(@PathVariable Integer id){
        System.out.println();
        return paymentService.getById(id);

    }
}

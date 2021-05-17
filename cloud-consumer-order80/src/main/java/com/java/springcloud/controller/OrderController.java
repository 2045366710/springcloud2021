package com.java.springcloud.controller;

import com.java.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get/payment/{id}")
    public Payment getPayment(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8001/payment/get/"+id,Payment.class);
    }
}

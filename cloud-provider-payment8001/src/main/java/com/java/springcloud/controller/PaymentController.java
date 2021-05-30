package com.java.springcloud.controller;

import com.java.springcloud.entities.Payment;
import com.java.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("get/{id}")
    public Payment getById(@PathVariable Integer id){
        System.out.println("serverPort:"+serverPort);
        return paymentService.getById(id);

    }


    @GetMapping("get/testDisclient")
    public void testDisclient(){
        List<String> services = discoveryClient.getServices();
        services.forEach((service)->{
            System.out.println(service);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");

        instances.forEach((instance)->{
            System.out.println(instance.getServiceId()+instance.getHost()+instance.getPort()+instance.getUri());
        });

        List<ServiceInstance> instances2 = discoveryClient.getInstances("cloud-order-server");

        instances2.forEach((instance)->{
            System.out.println(instance);
        });

    }
}

package com.xiong.controller;

import com.xiong.entity.JsonResult;
import com.xiong.entity.Payment;
import com.xiong.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("get/{id}")
    public JsonResult<Payment> getByid(@PathVariable("id") Long id){
        JsonResult<Payment> result = new JsonResult<>();
        result.setData(paymentService.querrybyId(id));
        result.setMessage("查找成功");
        result.setState(200);
        return result;
    }

    @PostMapping("create")
    public JsonResult<Void> add(@RequestBody Payment payment){
        JsonResult<Void> result = new JsonResult<>();
        System.out.println(payment.getSerial());
        paymentService.create(payment);
        result.setData(null);
        result.setMessage("添加成功");
        result.setState(200);
        return result;
    }


    @GetMapping("discovery")
    public Object hh(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }

        return services;
    }
}

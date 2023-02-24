package com.xiong.controller;

import com.xiong.entity.JsonResult;
import com.xiong.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("get")
    public JsonResult<Void> get(Long id){

        JsonResult result = restTemplate.getForObject(PAYMENT_URL+"payment/get/"+id, JsonResult.class);
        System.out.println(result);
        return result;
    }

    @PostMapping("create")
    public JsonResult<Void> create(Payment payment){
        JsonResult result = restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, JsonResult.class);
        return result;
    }
}

package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController
{
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/sms")
    public String sms()
    {
        return "sms provider service: "+"\t"+serverPort;
    }
}

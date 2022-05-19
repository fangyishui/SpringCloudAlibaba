package com.springcloud.service;

import org.springframework.stereotype.Component;

@Component //必须加 //必须加 //必须加
public class PaymentFallbackService implements PaymentHystrixService
{
//    @Override
//    public String getPaymentInfo(Integer id)
//    {
//        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
//    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentFallbackService---paymentInfo_OK---fallback()";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---PaymentFallbackService---paymentInfo_TimeOut---fallback()";
    }
}

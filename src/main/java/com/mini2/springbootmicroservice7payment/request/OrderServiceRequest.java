package com.mini2.springbootmicroservice7payment.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "order-service", path="/order")
public interface OrderServiceRequest {
    @GetMapping("{orderId}")
    Integer getOrderById(@PathVariable("orderId") Integer orderId);

    @GetMapping("{orderId}")
    Double getTotalPrice(@PathVariable("orderId") Integer orderId);

}

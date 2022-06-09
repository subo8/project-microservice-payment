package com.mini2.springbootmicroservice7payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDto {
    private Integer orderId;
    private LocalDateTime orderDate;
    private Double totalPrice;
}

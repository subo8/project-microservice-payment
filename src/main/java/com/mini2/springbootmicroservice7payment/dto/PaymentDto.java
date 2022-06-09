package com.mini2.springbootmicroservice7payment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mini2.springbootmicroservice7payment.model.Payment;
import com.mini2.springbootmicroservice7payment.model.PaymentStatus;
import com.mini2.springbootmicroservice7payment.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentDto {
    private Long id;
    private Boolean isPayed;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private LocalDateTime paidTime;
    private Integer orderId;
    private Double totalPrice;

    public PaymentDto(Payment payment) {
        this.setId(payment.getId());
        this.setIsPayed(payment.getIsPayed());
//        this.setPaymentStatus(payment.getPaymentStatus());
//        this.setPaymentType(payment.getPaymentType());
        this.setPaidTime(payment.getPaymentTime());
        this.setOrderId(payment.getOrderId());
    }
}

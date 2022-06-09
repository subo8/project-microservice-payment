package com.mini2.springbootmicroservice7payment.service;

import com.mini2.springbootmicroservice7payment.dto.PaymentDto;
import com.mini2.springbootmicroservice7payment.model.Payment;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> findAll();

    Payment addPayment(PaymentDto paymentDto);

    Payment payPayment(Long paymentId, PaymentDto paymentDto);

}

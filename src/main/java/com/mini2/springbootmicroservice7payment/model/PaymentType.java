package com.mini2.springbootmicroservice7payment.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentType {
    PAYPAL("paypal"),
    CARD("card");

    private final String paymentType;
}

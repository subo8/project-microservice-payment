package com.mini2.springbootmicroservice7payment.model;

import com.mini2.springbootmicroservice7payment.dto.PaymentDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "is_payed")
    private Boolean isPayed;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name= "payment_type")
    private PaymentType paymentType;

    @Column(name = "payment_time", nullable = false)
    private LocalDateTime paymentTime;

    public Payment(){}
    public Payment(PaymentDto paymentDto) {
        this.paymentTime = LocalDateTime.now();
        this.orderId = paymentDto.getOrderId();
        this.isPayed = paymentDto.getIsPayed();
//        this.paymentStatus = paymentDto.getPaymentStatus();
        this.paymentType = paymentDto.getPaymentType();
    }
}

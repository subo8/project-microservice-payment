package com.mini2.springbootmicroservice7payment.service;

import com.mini2.springbootmicroservice7payment.dto.PaymentDto;
import com.mini2.springbootmicroservice7payment.model.Payment;
import com.mini2.springbootmicroservice7payment.model.PaymentStatus;
import com.mini2.springbootmicroservice7payment.model.PaymentType;
import com.mini2.springbootmicroservice7payment.repository.PaymentRepository;
import com.mini2.springbootmicroservice7payment.request.OrderServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private final PaymentRepository paymentRepository;

    @Autowired
    private final OrderServiceRequest orderServiceRequest;

    public static PaymentDto getPaymentDtoFromPayment(Payment payment) {
        PaymentDto paymentDto = new PaymentDto(payment);
        return paymentDto;
    }

    @Override
    public List<PaymentDto> findAll() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment payment: payments) {
            PaymentDto paymentDto = getPaymentDtoFromPayment(payment);
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }

    public static Payment getPaymentFromDto(PaymentDto paymentDto) {
        Payment payment = new Payment(paymentDto);
        return payment;
    }

    @Override
    public Payment addPayment(PaymentDto paymentDto) {
        Payment payment = getPaymentFromDto(paymentDto);
        payment.setPaymentTime(LocalDateTime.now());
        payment.setIsPayed(false);
        payment.setPaymentType(PaymentType.PAYPAL);
        payment.setPaymentStatus(PaymentStatus.IN_PROGRESS);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment payPayment(Long paymentId, PaymentDto paymentDto) {
        Payment payment = getPaymentFromDto(paymentDto);
        payment.setId(paymentId);
        payment.setIsPayed(true);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        return paymentRepository.save(payment);
    }
}

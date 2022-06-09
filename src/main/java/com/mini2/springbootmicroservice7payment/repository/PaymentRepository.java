package com.mini2.springbootmicroservice7payment.repository;

import com.mini2.springbootmicroservice7payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

package com.mini2.springbootmicroservice7payment.controller;

import com.mini2.springbootmicroservice7payment.dto.PaymentDto;
import com.mini2.springbootmicroservice7payment.request.OrderServiceRequest;
import com.mini2.springbootmicroservice7payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderServiceRequest orderServiceRequest;

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getPayments() {
        List<PaymentDto> body = paymentService.findAll();
        return new ResponseEntity<List<PaymentDto>>(body, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addPayments(@RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentService.addPayment(paymentDto), HttpStatus.CREATED);
    }

    @PostMapping("/pay/{paymentId}")
    public ResponseEntity<?> pay(@PathVariable("paymentId") Long paymentId, @RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentService.payPayment(paymentId, paymentDto), HttpStatus.OK);
    }
}

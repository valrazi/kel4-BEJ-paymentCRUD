package com.kel4.paymentcrud.controller;

import com.kel4.paymentcrud.model.Payment;
import com.kel4.paymentcrud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService ps;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment(){
        return ps.getAllPayment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable Integer id){
        return ps.getPaymentById(id);
    }

    @PostMapping
    public ResponseEntity<Payment> postPayment(@RequestBody Payment payment){
        return ps.addPayment(payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable Integer id){
        return ps.removePayment(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Payment> patchPayment(@PathVariable Integer id, @RequestBody Payment payment){
        return ps.updatePayment(id, payment);
    }
}

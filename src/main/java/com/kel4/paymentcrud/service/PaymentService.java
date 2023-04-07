package com.kel4.paymentcrud.service;

import com.kel4.paymentcrud.model.Payment;
import com.kel4.paymentcrud.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository pr;

    public ResponseEntity<List<Payment>> getAllPayment(){
        try{
            List<Payment> payments = new ArrayList<Payment>();

            pr.findAll().forEach(payments::add);

            if (payments.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(payments, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Optional<Payment>> getPaymentById(Integer id){
        Optional<Payment> pm = pr.findById(id);
        if(pm.isPresent()){
            return new ResponseEntity<>(pm, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Payment> addPayment(Payment payment){
        try{
            Payment pm = pr.save(payment);
            return new ResponseEntity<>(pm, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> removePayment(Integer paymentId){
        try{
            pr.deleteById(paymentId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Payment> updatePayment(Integer paymentId, Payment payment){
        Optional<Payment> pm = pr.findById(paymentId);

        if(pm.isPresent()){
            Payment updatePayment = pm.get();
            updatePayment.setCustomerId(payment.getCustomerId());
            updatePayment.setStaffId(payment.getStaffId());
            updatePayment.setRentalId(payment.getRentalId());
            updatePayment.setAmount(payment.getAmount());
            updatePayment.setLastUpdate(payment.getLastUpdate());

            return new ResponseEntity<>(pr.save(updatePayment), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

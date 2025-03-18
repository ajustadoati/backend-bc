package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.application.service.PaymentTypeService;
import com.ajustadoati.bc.domain.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-types")
public class PaymentTypeController {

  @Autowired
  private PaymentTypeService paymentTypeService;

  @GetMapping
  public List<PaymentType> getAllPaymentTypes() {
    return paymentTypeService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<PaymentType> getPaymentTypeById(@PathVariable Integer id) {
    Optional<PaymentType> paymentType = paymentTypeService.findById(id);
    return paymentType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public PaymentType createPaymentType(@RequestBody PaymentType paymentType) {
    return paymentTypeService.save(paymentType);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PaymentType> updatePaymentType(@PathVariable Integer id, @RequestBody PaymentType paymentTypeDetails) {
    Optional<PaymentType> paymentType = paymentTypeService.findById(id);
    if (paymentType.isPresent()) {
      PaymentType updatedPaymentType = paymentType.get();
      updatedPaymentType.setPaymentTypeName(paymentTypeDetails.getPaymentTypeName());
      return ResponseEntity.ok(paymentTypeService.save(updatedPaymentType));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePaymentType(@PathVariable Integer id) {
    if (paymentTypeService.findById(id).isPresent()) {
      paymentTypeService.deleteById(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
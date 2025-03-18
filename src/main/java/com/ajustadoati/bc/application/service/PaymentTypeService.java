package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.repository.PaymentTypeRepository;
import com.ajustadoati.bc.domain.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTypeService {

  @Autowired
  private PaymentTypeRepository paymentTypeRepository;

  public List<PaymentType> findAll() {
    return paymentTypeRepository.findAll();
  }

  public Optional<PaymentType> findById(Integer id) {
    return paymentTypeRepository.findById(id);
  }

  public PaymentType save(PaymentType paymentType) {
    return paymentTypeRepository.save(paymentType);
  }

  public void deleteById(Integer id) {
    paymentTypeRepository.deleteById(id);
  }
}
package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.repository.DailyPaymentTypeRepository;
import com.ajustadoati.bc.domain.DailyPayment;
import com.ajustadoati.bc.domain.DailyPaymentType;
import com.ajustadoati.bc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyPaymentTypeService {

  @Autowired
  private DailyPaymentTypeRepository dailyPaymentTypeRepository;

  public List<DailyPaymentType> findAll() {
    return dailyPaymentTypeRepository.findAll();
  }

  public List<DailyPaymentType> findAllByDailyPayment(Integer dailyPaymentId) {
    var dailyPayment = new DailyPayment();
    dailyPayment.setId(dailyPaymentId);
    return dailyPaymentTypeRepository.findAllByDailyPayment(dailyPayment);
  }

  public Optional<DailyPaymentType> findById(Integer id) {
    return dailyPaymentTypeRepository.findById(id);
  }

  public DailyPaymentType save(DailyPaymentType dailyPaymentType) {
    return dailyPaymentTypeRepository.save(dailyPaymentType);
  }

  public void deleteById(Integer id) {
    dailyPaymentTypeRepository.deleteById(id);
  }
}
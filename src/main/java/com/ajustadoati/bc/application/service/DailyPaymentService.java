package com.ajustadoati.bc.application.service;


import com.ajustadoati.bc.adapter.rest.dto.DailyPaymentDto;
import com.ajustadoati.bc.adapter.rest.repository.DailyPaymentRepository;
import com.ajustadoati.bc.adapter.rest.repository.DailyPaymentTypeRepository;
import com.ajustadoati.bc.application.mapper.DailyPaymentMapper;
import com.ajustadoati.bc.domain.DailyPayment;
import com.ajustadoati.bc.domain.DailyPaymentType;
import com.ajustadoati.bc.domain.PaymentType;
import com.ajustadoati.bc.domain.User;
import com.ajustadoati.bc.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DailyPaymentService {

  @Autowired
  private DailyPaymentRepository dailyPaymentRepository;

  @Autowired
  private DailyPaymentTypeRepository dailyPaymentTypeRepository;

  @Autowired
  private DailyPaymentMapper dailyPaymentMapper;

  public List<DailyPayment> findAll() {
    return dailyPaymentRepository.findAll();
  }

  public List<DailyPayment> findAllByUserId(Integer userId) {
    var user = new User();
    user.setUserId(userId);
    ;
    return dailyPaymentRepository.findAllByUser(user);
  }

  public Optional<DailyPayment> findById(Integer id) {
    return dailyPaymentRepository.findById(id);
  }


  public DailyPayment save(DailyPaymentDto dailyPaymentDto) {
    DailyPayment dailyPayment = dailyPaymentMapper.toEntity(dailyPaymentDto);

    // Set Vehicle entity
    Vehicle vehicle = new Vehicle();
    vehicle.setId(dailyPaymentDto.getVehicleId());
    dailyPayment.setVehicle(vehicle);

    // Set User entity
    User user = new User();
    user.setUserId(dailyPaymentDto.getUserId());
    dailyPayment.setUser(user);

    // Set UserColector entity
    if(Objects.nonNull(dailyPaymentDto.getUserColectorId())) {
      User userColector = new User();
      userColector.setUserId(dailyPaymentDto.getUserColectorId());
      dailyPayment.setUserColector(userColector);
    }

    User userColector = new User();
    userColector.setUserId(dailyPaymentDto.getUserColectorId());
    dailyPayment.setUserColector(userColector);

    var userDriver = new User();
    userDriver.setUserId(dailyPaymentDto.getUserDriverId());
    dailyPayment.setUserDriver(userDriver);

    var dailyPaymentSaved = dailyPaymentRepository.save(dailyPayment);
    // Set DailyPaymentType entities
    List<DailyPaymentType> dailyPaymentTypes = dailyPaymentDto.getDailyPaymentTypes().stream()
      .map(dailyPaymentTypeDto -> new DailyPaymentType(null, dailyPaymentSaved,
        new PaymentType(dailyPaymentTypeDto.getPaymentTypeId(), "name"),
        dailyPaymentTypeDto.getAmount()))
      .collect(Collectors.toList());

    dailyPaymentTypeRepository.saveAll(dailyPaymentTypes);

    return dailyPaymentSaved;
  }

  public void deleteById(Integer id) {
    dailyPaymentRepository.deleteById(id);
  }
}
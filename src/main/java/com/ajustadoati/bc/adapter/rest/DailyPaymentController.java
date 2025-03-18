package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.adapter.rest.dto.DailyPaymentDto;
import com.ajustadoati.bc.application.mapper.DailyPaymentMapper;
import com.ajustadoati.bc.application.service.DailyPaymentService;
import com.ajustadoati.bc.domain.DailyPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/daily-payments")
public class DailyPaymentController {

  @Autowired
  private DailyPaymentMapper dailyPaymentMapper;

  @Autowired
  private DailyPaymentService dailyPaymentService;

  @GetMapping
  public List<DailyPayment> getAllDailyPayments() {
    return dailyPaymentService.findAll();
  }

  @GetMapping("/{userId}/user")
  public List<DailyPaymentDto> getAllDailyPayments(@PathVariable Integer userId) {
    return dailyPaymentService.findAllByUserId(userId).stream().map(dailyPaymentMapper::toDto)
      .toList();
  }


  @GetMapping("/{id}")
  public ResponseEntity<DailyPaymentDto> getDailyPaymentById(@PathVariable Integer id) {
    var dailyPayment = dailyPaymentMapper.toDto(dailyPaymentService.findById(id).orElseThrow());
    return new ResponseEntity<>(dailyPayment, HttpStatus.OK);
  }

  @PostMapping
  public DailyPaymentDto createDailyPayment(@RequestBody DailyPaymentDto dailyPaymentDto) {
    return dailyPaymentMapper.toDto(dailyPaymentService.save(dailyPaymentDto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<DailyPaymentDto> updateDailyPayment(@PathVariable Integer id,
    @RequestBody DailyPaymentDto dailyPaymentDetails) {
    Optional<DailyPayment> dailyPayment = dailyPaymentService.findById(id);
    return new ResponseEntity<>(
      dailyPaymentMapper.toDto(dailyPaymentService.save(dailyPaymentDetails)), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDailyPayment(@PathVariable Integer id) {
    if (dailyPaymentService.findById(id).isPresent()) {
      dailyPaymentService.deleteById(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
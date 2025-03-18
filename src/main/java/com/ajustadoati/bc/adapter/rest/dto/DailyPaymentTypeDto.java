package com.ajustadoati.bc.adapter.rest.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyPaymentTypeDto {
  private Integer id;
  private Integer dailyPaymentId;
  private Integer paymentTypeId;
  private BigDecimal amount;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDailyPaymentId() {
    return dailyPaymentId;
  }

  public void setDailyPaymentId(Integer dailyPaymentId) {
    this.dailyPaymentId = dailyPaymentId;
  }

  public Integer getPaymentTypeId() {
    return paymentTypeId;
  }

  public void setPaymentTypeId(Integer paymentTypeId) {
    this.paymentTypeId = paymentTypeId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
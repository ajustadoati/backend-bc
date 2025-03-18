package com.ajustadoati.bc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "daily_payment_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyPaymentType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "daily_payment_id")
  private DailyPayment dailyPayment;

  @ManyToOne
  @JoinColumn(name = "payment_type_id")
  private PaymentType paymentType;

  private BigDecimal amount;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DailyPayment getDailyPayment() {
    return dailyPayment;
  }

  public void setDailyPayment(DailyPayment dailyPayment) {
    this.dailyPayment = dailyPayment;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
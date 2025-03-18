package com.ajustadoati.bc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_type_id")
  private Integer paymentTypeId;
  private String paymentTypeName;

  public Integer getPaymentTypeId() {
    return paymentTypeId;
  }

  public void setPaymentTypeId(Integer paymentTypeId) {
    this.paymentTypeId = paymentTypeId;
  }

  public String getPaymentTypeName() {
    return paymentTypeName;
  }

  public void setPaymentTypeName(String paymentTypeName) {
    this.paymentTypeName = paymentTypeName;
  }
}

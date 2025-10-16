package com.ajustadoati.bc.adapter.rest.dto;


import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyPaymentDto {
  private Integer dailyPaymentId;
  private Integer userId;
  private Integer userColectorId;
  private Integer userDriverId;
  private Integer userSecondDriverId;
  private Integer vehicleId;
  private Date dailyDate;
  private Integer kilometerStart;
  private Integer kilometerEnd;
  List<DailyPaymentTypeDto> dailyPaymentTypes;

  public Integer getUserDriverId() {
    return userDriverId;
  }

  public void setUserDriverId(Integer userDriverId) {
    this.userDriverId = userDriverId;
  }

  public Integer getUserSecondDriverId() {
    return userSecondDriverId;
  }

  public void setUserSecondDriverId(Integer userSecondDriverId) {
    this.userSecondDriverId = userSecondDriverId;
  }

  public Integer getDailyPaymentId() {
    return dailyPaymentId;
  }

  public void setDailyPaymentId(Integer dailyPaymentId) {
    this.dailyPaymentId = dailyPaymentId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getUserColectorId() {
    return userColectorId;
  }

  public void setUserColectorId(Integer userColectorId) {
    this.userColectorId = userColectorId;
  }

  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Date getDailyDate() {
    return dailyDate;
  }

  public void setDailyDate(Date dailyDate) {
    this.dailyDate = dailyDate;
  }

  public Integer getKilometerStart() {
    return kilometerStart;
  }

  public void setKilometerStart(Integer kilometerStart) {
    this.kilometerStart = kilometerStart;
  }

  public Integer getKilometerEnd() {
    return kilometerEnd;
  }

  public void setKilometerEnd(Integer kilometerEnd) {
    this.kilometerEnd = kilometerEnd;
  }

  public List<DailyPaymentTypeDto> getDailyPaymentTypes() {
    return dailyPaymentTypes;
  }

  public void setDailyPaymentTypes(
    List<DailyPaymentTypeDto> dailyPaymentTypes) {
    this.dailyPaymentTypes = dailyPaymentTypes;
  }
}
package com.ajustadoati.bc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "daily_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyPayment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "user_colector_id")
  private User userColector;

  @ManyToOne
  @JoinColumn(name = "vehicle_id")
  private Vehicle vehicle;

  @ManyToOne
  @JoinColumn(name = "user_driver_id")
  private User userDriver;

  @ManyToOne
  @JoinColumn(name = "user_second_driver_id")
  private User userSecondDriver;

  private Date dailyDate;
  private Integer kilometerStart;
  private Integer kilometerEnd;

  @OneToMany(mappedBy = "dailyPayment", fetch = FetchType.LAZY)
  private List<DailyPaymentType> dailyPaymentTypes;

  public List<DailyPaymentType> getDailyPaymentTypes() {
    return dailyPaymentTypes;
  }

  public void setDailyPaymentTypes(
    List<DailyPaymentType> dailyPaymentTypes) {
    this.dailyPaymentTypes = dailyPaymentTypes;
  }

  public User getUserDriver() {
    return userDriver;
  }

  public void setUserDriver(User userDriver) {
    this.userDriver = userDriver;
  }

  public User getUserSecondDriver() {
    return userSecondDriver;
  }

  public void setUserSecondDriver(User userSecondDriver) {
    this.userSecondDriver = userSecondDriver;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUserColector() {
    return userColector;
  }

  public void setUserColector(User userColector) {
    this.userColector = userColector;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
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
}
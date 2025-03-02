package com.ajustadoati.bc.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VehicleDto {
  private int id;
  private int numberId;
  private String model;
  private String serial;
  private String marca;
  private String company;
  private String userId;
  private Integer vehicleType;

  public Integer getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(Integer vehicleType) {
    this.vehicleType = vehicleType;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNumberId() {
    return numberId;
  }

  public void setNumberId(int numberId) {
    this.numberId = numberId;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }
}

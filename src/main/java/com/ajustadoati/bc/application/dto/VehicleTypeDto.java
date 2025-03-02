package com.ajustadoati.bc.application.dto;

import lombok.Data;

@Data
public class VehicleTypeDto {
  private int id;
  private String type;

  public VehicleTypeDto() {
  }

  public VehicleTypeDto(int id, String type) {
    this.id = id;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}

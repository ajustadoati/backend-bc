package com.ajustadoati.bc.adapter.rest.exception;

public class VehicleNotFoundException extends RuntimeException {
  private String message;

  public VehicleNotFoundException(String message) {
    super(message);
  }

}

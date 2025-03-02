package com.ajustadoati.bc.adapter.rest.advice;

public class AssociationAlreadyExistsException extends RuntimeException {
  public AssociationAlreadyExistsException(String message) {
    super(message);
  }
}
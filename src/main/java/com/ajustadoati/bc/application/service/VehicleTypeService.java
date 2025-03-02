package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.repository.VehicleTypeRepository;
import com.ajustadoati.bc.domain.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {

  private final VehicleTypeRepository vehicleTypeRepository;

  public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
    this.vehicleTypeRepository = vehicleTypeRepository;
  }

  public List<VehicleType> getAllVehiclesType(){

    return vehicleTypeRepository.findAll();
  }
}

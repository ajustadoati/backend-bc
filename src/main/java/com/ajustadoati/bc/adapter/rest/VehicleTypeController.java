package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.application.dto.VehicleDto;
import com.ajustadoati.bc.application.dto.VehicleTypeDto;
import com.ajustadoati.bc.application.service.VehicleService;
import com.ajustadoati.bc.application.service.VehicleTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles-type")
public class VehicleTypeController {

  private final VehicleTypeService vehicleTypeService;

  public VehicleTypeController(VehicleTypeService vehicleTypeService) {
    this.vehicleTypeService = vehicleTypeService;
  }

  @GetMapping
  public ResponseEntity<List<VehicleTypeDto>> getAllVehiclesType() {

    var types = vehicleTypeService.getAllVehiclesType().stream()
      .map(vehicleType -> new VehicleTypeDto(vehicleType.getId().intValue(),
        vehicleType.getType()))
      .toList();
    return new ResponseEntity<>(types, HttpStatus.OK);
  }

}

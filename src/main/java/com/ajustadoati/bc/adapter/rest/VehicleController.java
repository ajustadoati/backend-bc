package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.application.dto.VehicleDto;
import com.ajustadoati.bc.application.service.VehicleService;
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
@RequestMapping("/api/vehicles")
public class VehicleController {

  private final VehicleService vehicleService;

  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping
  public List<VehicleDto> getAllVehicles() {
    return vehicleService.getAllVehicles();
  }

  @GetMapping("/{id}")
  public ResponseEntity<VehicleDto> getVehicleById(@PathVariable int id) {
    VehicleDto vehicle = vehicleService.getVehicleById(id);
    return ResponseEntity.ok(vehicle);
  }

  @GetMapping("/{userId}/user")
  public ResponseEntity<List<VehicleDto> > getVehicleById(@PathVariable Integer userId) {
    var vehicles = vehicleService.getAllVehiclesByUser(userId);
    return ResponseEntity.ok(vehicles);
  }

  @PostMapping
  public VehicleDto createVehicle(@RequestBody VehicleDto vehicleDto) {
    return vehicleService.saveVehicle(vehicleDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVehicle(@PathVariable int id) {
    vehicleService.deleteVehicle(id);
    return ResponseEntity.noContent().build();
  }
}

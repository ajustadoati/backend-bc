package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.exception.VehicleNotFoundException;
import com.ajustadoati.bc.adapter.rest.repository.UserRepository;
import com.ajustadoati.bc.adapter.rest.repository.VehicleRepository;
import com.ajustadoati.bc.adapter.rest.repository.VehicleTypeRepository;
import com.ajustadoati.bc.application.dto.VehicleDto;
import com.ajustadoati.bc.domain.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  private final UserRepository userRepository;

  private final VehicleTypeRepository vehicleTypeRepository;

  public VehicleService(VehicleRepository vehicleRepository, UserRepository userRepository,
    VehicleTypeRepository vehicleTypeRepository) {
    this.vehicleRepository = vehicleRepository;
    this.userRepository = userRepository;
    this.vehicleTypeRepository = vehicleTypeRepository;
  }

  public List<VehicleDto> getAllVehicles() {
    return vehicleRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
  }

  public List<VehicleDto> getAllVehiclesByUser(String numberId) {
    var user = userRepository.findByNumberId(numberId).orElseThrow();
    return vehicleRepository.findAllByUser(user).stream().map(this::convertToDto).toList();
  }

  public VehicleDto getVehicleById(int id) {
    Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with id: " + id));
    return convertToDto(vehicle);
  }

  public VehicleDto saveVehicle(VehicleDto vehicleDto) {
    Vehicle vehicle = new Vehicle();
    vehicle.setNumberId(vehicleDto.getNumberId());
    vehicle.setModel(vehicleDto.getModel());
    vehicle.setSerial(vehicleDto.getSerial());
    vehicle.setMarca(vehicleDto.getMarca());
    vehicle.setCompany(vehicleDto.getCompany());
    var vehicleType = vehicleTypeRepository.findById(vehicleDto.getVehicleType()).orElseThrow();
    var user = userRepository.findByNumberId(vehicleDto.getUserId()).orElseThrow();
    vehicle.setUser(user);
    vehicle.setVehicleType(vehicleType);
    Vehicle savedVehicle = vehicleRepository.save(vehicle);
    return convertToDto(savedVehicle);
  }

  public void deleteVehicle(int id) {
    if (!vehicleRepository.existsById(id)) {
      throw new VehicleNotFoundException("Vehicle not found with id: " + id);
    }
    vehicleRepository.deleteById(id);
  }

  private VehicleDto convertToDto(Vehicle vehicle) {
    VehicleDto dto = new VehicleDto();
    dto.setId(vehicle.getId());
    dto.setNumberId(vehicle.getNumberId());
    dto.setModel(vehicle.getModel());
    dto.setSerial(vehicle.getSerial());
    dto.setMarca(vehicle.getMarca());
    dto.setCompany(vehicle.getCompany());
    return dto;
  }
}

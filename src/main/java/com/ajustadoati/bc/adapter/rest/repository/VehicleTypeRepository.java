package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.Vehicle;
import com.ajustadoati.bc.domain.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer>  {

}

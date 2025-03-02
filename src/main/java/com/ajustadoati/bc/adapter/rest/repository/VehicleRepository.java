package com.ajustadoati.bc.adapter.rest.repository;


import com.ajustadoati.bc.domain.User;
import com.ajustadoati.bc.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

  List<Vehicle> findAllByUser(User user);
}

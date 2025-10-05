package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.DailyPayment;
import com.ajustadoati.bc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPaymentRepository extends JpaRepository<DailyPayment, Integer> {

  List<DailyPayment> findAllByUser(User user);

  List<DailyPayment> findAllByVehicleId(Integer vehicleId);

}

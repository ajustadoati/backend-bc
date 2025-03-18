package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.DailyPayment;
import com.ajustadoati.bc.domain.DailyPaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPaymentTypeRepository extends JpaRepository<DailyPaymentType, Integer> {

  List<DailyPaymentType> findAllByDailyPayment(DailyPayment dailyPayment);


}
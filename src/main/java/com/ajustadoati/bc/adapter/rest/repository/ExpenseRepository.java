package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.Expense;
import com.ajustadoati.bc.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    public List<Expense> findByVehicle(Vehicle vehicle);
}


package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer> {

    List<ExpenseType> findByExpenseCategoryId(Integer expenseCategoryId);
}

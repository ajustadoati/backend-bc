package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseTypeDto;
import com.ajustadoati.bc.adapter.rest.repository.ExpenseCategoryRepository;
import com.ajustadoati.bc.adapter.rest.repository.ExpenseTypeRepository;
import com.ajustadoati.bc.application.mapper.ExpenseTypeMapper;
import com.ajustadoati.bc.domain.ExpenseCategory;
import com.ajustadoati.bc.domain.ExpenseType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseTypeService {

    private final ExpenseTypeRepository expenseTypeRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ExpenseTypeMapper expenseTypeMapper;

    public ExpenseTypeService(
        ExpenseTypeRepository expenseTypeRepository,
        ExpenseCategoryRepository expenseCategoryRepository,
        ExpenseTypeMapper expenseTypeMapper
    ) {
        this.expenseTypeRepository = expenseTypeRepository;
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.expenseTypeMapper = expenseTypeMapper;
    }

    public List<ExpenseTypeDto> findByCategory(Integer categoryId) {
        return expenseTypeRepository.findByExpenseCategoryId(categoryId)
            .stream()
            .map(expenseTypeMapper::toDto)
            .collect(Collectors.toList());
    }

    public ExpenseTypeDto save(ExpenseTypeDto dto) {
        ExpenseType entity = expenseTypeMapper.toEntity(dto);
        ExpenseCategory category = expenseCategoryRepository.findById(dto.getExpenseCategoryId())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        entity.setExpenseCategory(category);
        ExpenseType saved = expenseTypeRepository.save(entity);
        return expenseTypeMapper.toDto(saved);
    }
}

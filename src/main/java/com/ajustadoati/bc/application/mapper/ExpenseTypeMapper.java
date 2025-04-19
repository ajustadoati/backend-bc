package com.ajustadoati.bc.application.mapper;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseTypeDto;
import com.ajustadoati.bc.domain.ExpenseType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseTypeMapper {
    @Mapping(source = "expenseCategory.id", target = "expenseCategoryId")
    ExpenseTypeDto toDto(ExpenseType entity);

    @Mapping(source = "expenseCategoryId", target = "expenseCategory.id")
    ExpenseType toEntity(ExpenseTypeDto dto);
}

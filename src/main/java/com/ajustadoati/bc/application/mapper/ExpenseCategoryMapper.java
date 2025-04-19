package com.ajustadoati.bc.application.mapper;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseCategoryDto;
import com.ajustadoati.bc.domain.ExpenseCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseCategoryMapper {
    ExpenseCategoryDto toDto(ExpenseCategory entity);
    ExpenseCategory toEntity(ExpenseCategoryDto dto);
}


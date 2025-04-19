package com.ajustadoati.bc.application.mapper;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseDto;
import com.ajustadoati.bc.domain.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(source = "expenseType.id", target = "expenseTypeId")
    @Mapping(source = "vehicle.id", target = "vehicleId")
    @Mapping(source = "workshop.id", target = "workshopId")
    ExpenseDto toDto(Expense entity);

    @Mapping(source = "expenseTypeId", target = "expenseType.id")
    @Mapping(source = "vehicleId", target = "vehicle.id")
    @Mapping(source = "workshopId", target = "workshop.id")
    Expense toEntity(ExpenseDto dto);
}


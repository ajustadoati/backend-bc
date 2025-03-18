package com.ajustadoati.bc.application.mapper;

import com.ajustadoati.bc.adapter.rest.dto.DailyPaymentTypeDto;
import com.ajustadoati.bc.domain.DailyPaymentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DailyPaymentTypeMapper {

  @Mapping(target = "dailyPaymentId", source = "dailyPayment.id")
  @Mapping(target = "paymentTypeId", source = "paymentType.paymentTypeId")
  DailyPaymentTypeDto toDto(DailyPaymentType dailyPaymentType);

  @Mapping(target = "dailyPayment.id", source = "dailyPaymentId")
  @Mapping(target = "paymentType.paymentTypeId", source = "paymentTypeId")
  DailyPaymentType toEntity(DailyPaymentTypeDto dailyPaymentTypeDto);

  List<DailyPaymentTypeDto> toDtoList(List<DailyPaymentType> dailyPaymentTypes);

  List<DailyPaymentType> toEntityList(List<DailyPaymentTypeDto> dailyPaymentTypeDtos);
}

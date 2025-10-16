package com.ajustadoati.bc.application.mapper;

import com.ajustadoati.bc.adapter.rest.dto.DailyPaymentDto;
import com.ajustadoati.bc.domain.DailyPayment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, DailyPaymentTypeMapper.class})
public interface DailyPaymentMapper {

  @Mapping(target = "dailyPaymentId", source = "id")
  @Mapping(target = "userId", source = "user.userId")
  @Mapping(target = "userColectorId", source = "userColector.userId")
  @Mapping(target = "userDriverId", source = "userDriver.userId")
  @Mapping(target = "userSecondDriverId", source = "userSecondDriver.userId")
  @Mapping(target = "vehicleId", source = "vehicle.id")
  DailyPaymentDto toDto(DailyPayment dailyPayment);

  @Mapping(target = "id", source = "dailyPaymentId")
  @Mapping(target = "user", ignore = true)
  @Mapping(target = "userColector", ignore = true)
  @Mapping(target = "userDriver", ignore = true)
  @Mapping(target = "userSecondDriver", ignore = true)
  @Mapping(target = "vehicle", ignore = true)
  @Mapping(target = "dailyPaymentTypes", ignore = true)
  DailyPayment toEntity(DailyPaymentDto dailyPaymentDto);

}

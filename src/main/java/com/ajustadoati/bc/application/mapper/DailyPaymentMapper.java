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
  @Mapping(target = "vehicleId", source = "vehicle.id")
  DailyPaymentDto toDto(DailyPayment dailyPayment);

  @Mapping(target = "id", source = "dailyPaymentId")
  @Mapping(target = "user.userId", source = "userId")
  @Mapping(target = "userColector.userId", source = "userColectorId")
  @Mapping(target = "userDriver.userId", source = "userDriverId")
  @Mapping(target = "vehicle.id", source = "vehicleId")
  DailyPayment toEntity(DailyPaymentDto dailyPaymentDto);

}

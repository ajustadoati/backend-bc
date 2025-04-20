package com.ajustadoati.bc.application.mapper;

import com.ajustadoati.bc.adapter.rest.dto.WorkshopDto;
import com.ajustadoati.bc.domain.Workshop;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkshopMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "direction", source = "direction")
    @Mapping(target = "mobileNumber", source = "mobileNumber")
    WorkshopDto toDto(Workshop workshop);

    @InheritInverseConfiguration
    Workshop toEntity(WorkshopDto dto);
}

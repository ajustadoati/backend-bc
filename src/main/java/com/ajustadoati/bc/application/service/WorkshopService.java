package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.dto.WorkshopDto;
import com.ajustadoati.bc.adapter.rest.repository.WorkshopRepository;
import com.ajustadoati.bc.application.mapper.WorkshopMapper;
import com.ajustadoati.bc.domain.Workshop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkshopService {

    private final WorkshopRepository workshopRepository;
    private final WorkshopMapper workshopMapper;

    public WorkshopService(WorkshopRepository workshopRepository, WorkshopMapper workshopMapper) {
        this.workshopRepository = workshopRepository;
        this.workshopMapper = workshopMapper;
    }

    public List<WorkshopDto> findAll() {
        return workshopRepository.findAll()
            .stream()
            .map(workshopMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<WorkshopDto> findAllByCompanyId(Integer companyId) {
        return workshopRepository.findByCompanyId(companyId)
            .stream()
            .map(workshopMapper::toDto)
            .collect(Collectors.toList());
    }

    public WorkshopDto save(WorkshopDto dto) {
        Workshop workshop = workshopMapper.toEntity(dto);
        return workshopMapper.toDto(workshopRepository.save(workshop));
    }

    public Optional<WorkshopDto> findById(Integer id) {
        return workshopRepository.findById(id).map(workshopMapper::toDto);
    }

    public void delete(Integer id) {
        workshopRepository.deleteById(id);
    }
}

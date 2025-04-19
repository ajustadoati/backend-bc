package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseDto;
import com.ajustadoati.bc.adapter.rest.repository.ExpenseRepository;
import com.ajustadoati.bc.adapter.rest.repository.VehicleRepository;
import com.ajustadoati.bc.application.mapper.ExpenseMapper;
import com.ajustadoati.bc.domain.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository repository;
    private final ExpenseMapper mapper;
    private final VehicleRepository vehicleRepository;

    public List<ExpenseDto> findAll() {
        return repository.findAll().stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    public List<ExpenseDto> findAllByVehicleId(Integer vehicleId){
        var vehicle = vehicleRepository.findById(vehicleId).orElseThrow();

        return repository.findByVehicle(vehicle).stream().map(mapper::toDto).toList();
    }

    public Optional<ExpenseDto> findById(Integer id) {
        return repository.findById(id)
            .map(mapper::toDto);
    }

    public ExpenseDto save(ExpenseDto dto) {
        Expense entity = mapper.toEntity(dto);
        Expense saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}


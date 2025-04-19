package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseCategoryDto;
import com.ajustadoati.bc.adapter.rest.repository.ExpenseCategoryRepository;
import com.ajustadoati.bc.application.mapper.ExpenseCategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {
    private final ExpenseCategoryRepository repository;
    private final ExpenseCategoryMapper mapper;

    public ExpenseCategoryService(ExpenseCategoryRepository repository, ExpenseCategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ExpenseCategoryDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public ExpenseCategoryDto save(ExpenseCategoryDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}

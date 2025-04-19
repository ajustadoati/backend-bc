package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseCategoryDto;
import com.ajustadoati.bc.application.service.ExpenseCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-categories")
public class ExpenseCategoryController {

    private final ExpenseCategoryService service;

    public ExpenseCategoryController(ExpenseCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExpenseCategoryDto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ExpenseCategoryDto create(@RequestBody ExpenseCategoryDto dto) {
        return service.save(dto);
    }
}


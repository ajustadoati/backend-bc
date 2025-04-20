package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseTypeDto;
import com.ajustadoati.bc.application.service.ExpenseTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-types")
public class ExpenseTypeController {

    private final ExpenseTypeService expenseTypeService;

    public ExpenseTypeController(ExpenseTypeService expenseTypeService) {
        this.expenseTypeService = expenseTypeService;
    }

    @GetMapping("/category/{categoryId}")
    public List<ExpenseTypeDto> getByCategory(@PathVariable Integer categoryId) {
        return expenseTypeService.findByCategory(categoryId);
    }

    @PostMapping
    public ExpenseTypeDto create(@RequestBody ExpenseTypeDto dto) {
        return expenseTypeService.save(dto);
    }
}


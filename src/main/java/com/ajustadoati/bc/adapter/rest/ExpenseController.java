package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.adapter.rest.dto.ExpenseDto;
import com.ajustadoati.bc.application.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExpenseDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{vehicleId}/vehicle")
    public List<ExpenseDto> getAllByVehicleId(@PathVariable Integer vehicleId) {
        return service.findAllByVehicleId(vehicleId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getById(@PathVariable Integer id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> create(@RequestBody ExpenseDto dto) {
        ExpenseDto created = service.save(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

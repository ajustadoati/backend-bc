package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.adapter.rest.dto.WorkshopDto;
import com.ajustadoati.bc.application.service.WorkshopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workshops")
public class WorkshopController {

    private final WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @GetMapping
    public List<WorkshopDto> getAll() {
        return workshopService.findAll();
    }

    @GetMapping(value="/{companyId}/company")
    public List<WorkshopDto> getAllByCompanyId(@PathVariable Integer companyId) {
        return workshopService.findAllByCompanyId(companyId);
    }

    @PostMapping
    public WorkshopDto create(@RequestBody WorkshopDto dto) {
        return workshopService.save(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkshopDto> getById(@PathVariable Integer id) {
        return workshopService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        workshopService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

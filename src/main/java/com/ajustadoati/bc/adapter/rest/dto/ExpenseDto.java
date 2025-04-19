package com.ajustadoati.bc.adapter.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseDto {
    private Integer id;
    private Integer expenseTypeId;
    private Integer vehicleId;
    private Integer workshopId;
    private LocalDate expenseDate;
    private String description;
    private Integer kilometer;
    private BigDecimal amount;
    private BigDecimal labour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(Integer expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Integer workshopId) {
        this.workshopId = workshopId;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public void setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getLabour() {
        return labour;
    }

    public void setLabour(BigDecimal labour) {
        this.labour = labour;
    }

}


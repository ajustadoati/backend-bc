package com.ajustadoati.bc.adapter.rest.dto;

import lombok.Data;

@Data
public class ExpenseTypeDto {
    private Integer id;
    private String name;
    private Integer expenseCategoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(Integer expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

}

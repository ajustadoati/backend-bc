package com.ajustadoati.bc.domain;

import jakarta.persistence.*;

// domain/ExpenseCategory.java
@Entity
@Table(name = "expense_category")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

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

}

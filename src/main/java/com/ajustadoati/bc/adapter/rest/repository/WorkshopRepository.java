package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Integer> {

    public List<Workshop> findByCompanyId(Integer companyId);
}

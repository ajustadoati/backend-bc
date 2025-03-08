package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.Company;
import com.ajustadoati.bc.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByNumberId(String numberId);

  Page<User> findByCompany(Company company, Pageable pageable);

}

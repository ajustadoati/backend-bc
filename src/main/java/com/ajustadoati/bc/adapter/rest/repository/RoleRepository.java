package com.ajustadoati.bc.adapter.rest.repository;

import com.ajustadoati.bc.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  @Query(
      "SELECT ro FROM Role ro WHERE ro.roleName IN " +
          "(:roleNames) ")
  Set<Role> findByRoleNames(Set<String> roleNames);

}

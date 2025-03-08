package com.ajustadoati.bc.application.service;

import com.ajustadoati.bc.adapter.rest.dto.request.CreateUserRequest;
import com.ajustadoati.bc.adapter.rest.repository.RoleRepository;
import com.ajustadoati.bc.adapter.rest.repository.UserRepository;
import com.ajustadoati.bc.domain.Company;
import com.ajustadoati.bc.domain.User;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Set;

/**
 * User service class
 *
 * @author rojasric
 */
@Service
public class UserService {

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;
  public UserService(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }



  public User createUser(CreateUserRequest createUserRequest) {

    var user = new User();
    user.setFirstName(createUserRequest.getFirstName());
    user.setLastName(createUserRequest.getLastName());
    user.setNumberId(createUserRequest.getNumberId());
    user.setMobileNumber(createUserRequest.getMobileNumber());
    user.setEmail(createUserRequest.getEmail());
    user.setCreatedAt(Instant.now());

    var company = new Company();
    company.setCompanyId(createUserRequest.getCompanyId());
    user.setCompany(company);

    var roles = roleRepository.findByRoleNames(Set.of(createUserRequest.getRol().name()));
    user.setRoles(roles);

    return userRepository.save(user);
  }


  public void updateUserPartial(Integer id, Map<String, Object> updates) {
    User user = userRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    updates.forEach((field, value) -> {
      BeanWrapper beanWrapper = new BeanWrapperImpl(user);
      if (beanWrapper.isWritableProperty(field)) {
        beanWrapper.setPropertyValue(field, value);
      } else {
        throw new IllegalArgumentException("Field '" + field + "' is not a valid property of User.");
      }
    });

    userRepository.save(user);
  }

  public User getUserById(Integer id) {
    return userRepository
      .findById(id)
      .orElseThrow();
  }

  public Page<User> getUserByUserId(String userId, Pageable pageable) {
    var user = userRepository.findByNumberId(userId).orElseThrow();

    return userRepository.findByCompany(user.getCompany(), pageable);
  }

  public User getUserByNumberId(String numberId) {
    return userRepository
      .findByNumberId(numberId)
      .orElseThrow();
  }

  public Page<User> getAllUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }


  public void delete(Integer id){
    User user = userRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    userRepository.delete(user);

  }

}

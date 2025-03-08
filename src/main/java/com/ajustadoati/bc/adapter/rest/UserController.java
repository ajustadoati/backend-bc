package com.ajustadoati.bc.adapter.rest;

import com.ajustadoati.bc.adapter.rest.assemblers.UserModelAssembler;
import com.ajustadoati.bc.adapter.rest.dto.request.CreateUserRequest;
import com.ajustadoati.bc.adapter.rest.dto.response.UserDto;
import com.ajustadoati.bc.application.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  private final UserModelAssembler userModelAssembler;

  private final PagedResourcesAssembler<UserDto> pagedResourcesAssembler;

  public UserController(UserService userService, UserModelAssembler userModelAssembler,
      PagedResourcesAssembler<UserDto> pagedResourcesAssembler) {
    this.userService = userService;
    this.userModelAssembler = userModelAssembler;
    this.pagedResourcesAssembler = pagedResourcesAssembler;
  }

  @PostMapping
  public ResponseEntity<EntityModel<UserDto>> createUser(
      @RequestBody @Validated CreateUserRequest createUserRequest) {
    var user = userService.createUser(createUserRequest);
    return new ResponseEntity<>(userModelAssembler.toModel(user), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<UserDto>> getUserById(@PathVariable Integer id) {
    var user = userService.getUserById(id);
    return new ResponseEntity<>(userModelAssembler.toModel(user), HttpStatus.OK);
  }

  @GetMapping("/numberId/{numberId}")
  public ResponseEntity<EntityModel<UserDto>> getUserByNumberId(@PathVariable String numberId) {
    var user = userService.getUserByNumberId(numberId);
    return new ResponseEntity<>(userModelAssembler.toModel(user), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<CollectionModel<EntityModel<UserDto>>> getAllUsers(Pageable pageable) {
    var users = userService.getAllUsers(pageable);

    PagedModel<EntityModel<UserDto>> pagedModel =
        userModelAssembler.toPagedModel(users, pagedResourcesAssembler);

    return ResponseEntity.ok(pagedModel);
  }

  @GetMapping("/{userId}/company")
  public ResponseEntity<CollectionModel<EntityModel<UserDto>>> getAllUsersByCompany(@PathVariable String userId, Pageable pageable) {
    var users = userService.getUserByUserId(userId, pageable);

    PagedModel<EntityModel<UserDto>> pagedModel =
      userModelAssembler.toPagedModel(users, pagedResourcesAssembler);

    return ResponseEntity.ok(pagedModel);
  }

  @PatchMapping("/{id}")
  public void updateUser(
    @PathVariable Integer id,
    @RequestBody Map<String, Object> updates) {
    userService.updateUserPartial(id, updates);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(
    @PathVariable Integer id) {
    userService.delete(id);
  }

}

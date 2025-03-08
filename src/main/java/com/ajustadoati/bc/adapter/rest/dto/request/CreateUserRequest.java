package com.ajustadoati.bc.adapter.rest.dto.request;

import com.ajustadoati.bc.adapter.rest.dto.enums.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

  private Integer id;

  @NotNull
  private String firstName;

  @NotNull
  private String lastName;

  @NotNull
  private String numberId;

  private String mobileNumber;

  @Email
  private String email;

  private UserTypeEnum rol;

  private Integer companyId;

}

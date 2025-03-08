package com.ajustadoati.bc.adapter.rest.dto.response;

import com.ajustadoati.bc.adapter.rest.dto.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Relation(collectionRelation = "collection")
public class UserDto {
  private Integer id;
  private String firstName;
  private String lastName; 
  private String numberId; 
  private String mobileNumber;
  private String email;
  private Integer companyId;
  private UserTypeEnum type;

  public UserDto() {

  }


  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getNumberId() {
    return numberId;
  }

  public void setNumberId(String numberId) {
    this.numberId = numberId;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserTypeEnum getType() {
    return type;
  }

  public void setType(UserTypeEnum type) {
    this.type = type;
  }
}

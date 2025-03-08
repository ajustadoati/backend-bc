
package com.ajustadoati.bc.application.mapper;

import com.ajustadoati.bc.adapter.rest.dto.enums.UserTypeEnum;
import com.ajustadoati.bc.adapter.rest.dto.response.UserDto;
import com.ajustadoati.bc.domain.Role;
import com.ajustadoati.bc.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * User mapper class
 *
 * @author rojasric
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "id", source = "userId")
  @Mapping(target = "companyId", source = "user.company.companyId")
  @Mapping(target = "type", source = "roles", qualifiedByName = "mapRoleNameToType")
  UserDto toDto(User user);

  @Named("mapRoleNameToType")
  default UserTypeEnum mapRoleNameToType(Set<Role> roles) {
    return roles.stream().findFirst().map(role -> UserTypeEnum.valueOf(role.getRoleName()))
      .orElseThrow();

  }


}

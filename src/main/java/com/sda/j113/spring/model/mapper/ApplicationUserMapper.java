package com.sda.j113.spring.model.mapper;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.dto.ApplicationUserDTO;
import com.sda.j113.spring.model.dto.CreateUserRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "productSet", ignore = true),
            @Mapping(target = "offers", ignore = true),
            @Mapping(target = "username", source = "login"),
            @Mapping(target = "password", source = "pass"),
            @Mapping(target = "firstName", source = "name"),
            @Mapping(target = "lastName", source = "surname"),
//            @Mapping(target = "lastName", source = "surname", conditionExpression = "java(request.getSurname() != null)"),
    })
    ApplicationUser mapCreateUserRequestToApplicationUser(CreateUserRequest request);

    @Mappings(value = {
            @Mapping(source = "id", target="id"),
            @Mapping(source = "username", target = "login"),
            @Mapping(source = "firstName", target = "name"),
            @Mapping(source = "lastName", target = "surname"),
    })
    ApplicationUserDTO mapApplicationUserToDTO(ApplicationUser applicationUser);

}
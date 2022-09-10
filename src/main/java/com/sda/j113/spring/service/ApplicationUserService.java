package com.sda.j113.spring.service;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.dto.ApplicationUserDTO;
import com.sda.j113.spring.model.dto.CreateUserRequest;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
public interface ApplicationUserService {
    ApplicationUserDTO addUser(CreateUserRequest request);
    List<ApplicationUserDTO> listUsers();
}

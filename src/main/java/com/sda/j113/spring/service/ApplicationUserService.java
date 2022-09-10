package com.sda.j113.spring.service;

import com.sda.j113.spring.model.ApplicationUser;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
public interface ApplicationUserService {
    ApplicationUser addUser(ApplicationUser user);
    List<ApplicationUser> listUsers();
}

package com.sda.j113.spring.controller;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    // Create -> Post  [/ **Put]
    // Read   -> Get
    // Update -> Put, Patch [*Post]
    // Delete -> Delete
    @GetMapping()
    public List<ApplicationUser> getListOfUsers(){
        return applicationUserService.listUsers();
    }

    @PostMapping()
    public ApplicationUser postNewUser(ApplicationUser newUser){
        return applicationUserService.addUser(newUser);
    }
}








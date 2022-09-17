package com.sda.j113.spring.controller;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.dto.ApplicationUserDTO;
import com.sda.j113.spring.model.dto.CreateUserRequest;
import com.sda.j113.spring.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    // Create -> Post  [/ **Put]
    // Read   -> Get
    // Update -> Put, Patch [*Post]
    // Delete -> Delete
    @GetMapping()
    @CrossOrigin()
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationUserDTO> getListOfUsers(){
        return applicationUserService.listUsers();
    }

    @PostMapping()
    @CrossOrigin()
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationUserDTO postNewUser(@RequestBody CreateUserRequest request){
        return applicationUserService.addUser(request);
    }
}








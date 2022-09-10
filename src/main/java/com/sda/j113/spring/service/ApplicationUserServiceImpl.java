package com.sda.j113.spring.service;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService{
    private final ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser addUser(ApplicationUser user) {
        return applicationUserRepository.save(user);
    }

    @Override
    public List<ApplicationUser> listUsers() {
        return applicationUserRepository.findAll();
    }
}

package com.sda.j113.spring.service;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 02.10.2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final ApplicationUserRepository applicationUserRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("Looking for user: " + username);
//
//        Optional<ApplicationUser> applicationUserOptional = applicationUserRepository.findByUsername(username);
//        if(applicationUserOptional.isPresent()){
//            return applicationUserOptional.get();
//        }
//
//        throw new UsernameNotFoundException("Username not found: " + username);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Looking for user: " + username);
        return applicationUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}

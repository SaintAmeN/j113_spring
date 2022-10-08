package com.sda.j113.spring.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.j113.spring.filter.AuthenticationFilter;
import com.sda.j113.spring.filter.LoginFilter;
import com.sda.j113.spring.model.mapper.ApplicationUserMapper;
import com.sda.j113.spring.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 02.10.2022
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;
    private final ApplicationUserMapper applicationUserMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    // wyłącz csrf (cross site request forgery)
                    .csrf().disable()
                    .cors()
                .and()
                // dalej konfigurujemy autoryzację requestów
                    .authorizeRequests()
//                        .antMatchers("/**").permitAll()
                        .antMatchers("/api/test/public").permitAll()                // dostępny dla każdego
                        .antMatchers("/api/test/anyone").authenticated()            // dla dowolnej osoby która jest zalogowana
                        .antMatchers("/api/test/moderator").hasRole("MODERATOR")    // dla dowolnej osoby która jest zalogowana z rolą moderator
                        .antMatchers("/api/test/admin").hasRole("ADMIN")            // dla dowolnej osoby która jest zalogowana z rolą admin
                        .anyRequest().authenticated()
                .and()
                    .addFilter(loginFilter(authenticationManager(), applicationUserMapper, objectMapper))       // /login
                    .addFilter(new AuthenticationFilter(authenticationManager()))                               // nie /login
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    private LoginFilter loginFilter(AuthenticationManager authenticationManager,
                                   ApplicationUserMapper applicationUserMapper,
                                   ObjectMapper objectMapper) {
        return new LoginFilter(
                authenticationManager,
                applicationUserMapper,
                objectMapper);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//        auth.authenticationProvider(daoAuthenticationProvider);

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}

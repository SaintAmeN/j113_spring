package com.sda.j113.spring.configuration;

import com.sda.j113.spring.model.config.DefaultUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 02.10.2022
 */
@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "application.default")
public class InitialUsersConfiguration {
    private List<String> roles;
    private List<DefaultUser> users;
}

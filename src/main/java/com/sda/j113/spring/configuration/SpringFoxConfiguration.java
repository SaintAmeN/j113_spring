package com.sda.j113.spring.configuration;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Configuration
public class SpringFoxConfiguration {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                // Documentation
                .apiInfo(new ApiInfo(
                        "Java 113! Hurra!",
                        "This is SDA Java Course 113! We are the best!",
                        "0.0.0.1",
                        null,
                        new Contact("Paweł", "http://sdacademy.pl", "pawel.reclaw@gmail.com"),
                        null,
                        null,
                        Collections.emptyList()
                ))
                .select()
                // Configuration
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.sda.j113.spring.controller"))
                .build();
        // http://localhost:8080/swagger-ui/index.html
    }
}

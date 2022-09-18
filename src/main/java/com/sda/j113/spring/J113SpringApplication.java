package com.sda.j113.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class J113SpringApplication {
    //
    // DI Module - jest wszędzie
    public static void main(String[] args) {
        SpringApplication.run(J113SpringApplication.class, args);
    }

}

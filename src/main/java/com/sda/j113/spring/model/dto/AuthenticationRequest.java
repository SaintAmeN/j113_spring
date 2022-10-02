package com.sda.j113.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 02.10.2022
 * <p>
 * Request:
 * {
 * "login": "XYZ",
 * "pass": "ZYX"
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String login;
    private String pass;
}

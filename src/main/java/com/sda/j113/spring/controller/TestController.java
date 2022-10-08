package com.sda.j113.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 08.10.2022
 */
@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/admin")
    public String testAdmin() {
        return "pong";
    }

    @GetMapping("/moderator")
    public String testModerator() {
        return "pong";
    }

    @GetMapping("/anyone")
    public String testAnyone() {
        return "pong";
    }

    @GetMapping("/public")
    public String testPublic() {
        return "pong";
    }
}

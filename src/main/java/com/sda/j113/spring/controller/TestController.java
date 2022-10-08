package com.sda.j113.spring.controller;

import com.sda.j113.spring.model.dto.MessageDTO;
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
    public MessageDTO testAdmin() {
        return new MessageDTO("pong");
    }

    @GetMapping("/moderator")
    public MessageDTO testModerator() {
        return new MessageDTO("pong");
    }

    @GetMapping("/anyone")
    public MessageDTO testAnyone() {
        return new MessageDTO("pong");
    }

    @GetMapping("/public")
    public MessageDTO testPublic() {
        return new MessageDTO("pong");
    }
}

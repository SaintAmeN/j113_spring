package com.sda.j113.spring.controller;

import com.sda.j113.spring.model.dto.AuctionDTO;
import com.sda.j113.spring.service.AuctionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 18.09.2022
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/auction")
@RequiredArgsConstructor
public class AuctionController {
    private final AuctionService auctionService;

    @GetMapping
    public Page<AuctionDTO> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "10") Integer size){
        log.info(String.format("Auction controller has been invoked with: %d %d", page, size));
        return auctionService.findAll(PageRequest.of(page, size));
    }


}

package com.sda.j113.spring.service;

import com.sda.j113.spring.model.dto.AuctionDTO;
import com.sda.j113.spring.model.dto.CreateAuctionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
public interface AuctionService {
    Page<AuctionDTO> findAll(PageRequest pageRequest);
    AuctionDTO createAuction(CreateAuctionRequest request);
}

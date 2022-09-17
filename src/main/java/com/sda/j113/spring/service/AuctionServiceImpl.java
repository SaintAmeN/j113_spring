package com.sda.j113.spring.service;

import com.sda.j113.spring.model.dto.AuctionDTO;
import com.sda.j113.spring.model.dto.CreateAuctionRequest;
import com.sda.j113.spring.repository.AuctionRepository;
import com.sda.j113.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

// @Component
// @Service
// @Repository
// @Controller
// @RestController
/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService{
    private final AuctionRepository auctionRepository;
    private final ProductRepository productRepository;

    // TODO: *dodać paginację do listy użytkowników
    // TODO: zadanie domowe: lista użytkowników - ma być zbudowana z 1 komponentu (przechowaj listę użytkowników w serwisie)
    //  Dla kontekstu:
    //  Product był robiony w postaci 3 komponentów:
    //      -- all products
    //      -- user products
    //      -- product list

    // TODO: zadanie domowe: uzupełnić
    // TODO: zadanie domowe: stworzyć controller (AuctionController) i dodać mapping do wyswietlania wszystkich
    @Override
    public Page<AuctionDTO> findAll(PageRequest pageRequest) {
        log.info("Find all request invoked with: " + pageRequest);
        return null;
    }

    // TODO: zadanie domowe: uzupełnić
    // TODO: zadanie domowe: stworzyć controller (AuctionController) i dodać mapping do dodawania
    @Override
    public AuctionDTO createAuction(CreateAuctionRequest request) {
        return null;
    }
}

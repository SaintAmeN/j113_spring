package com.sda.j113.spring.repository;

import com.sda.j113.spring.model.Auction;
import com.sda.j113.spring.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findAllByAuction(Auction auction);
}

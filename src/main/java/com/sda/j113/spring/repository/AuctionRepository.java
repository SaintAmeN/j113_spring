package com.sda.j113.spring.repository;

import com.sda.j113.spring.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
public interface AuctionRepository extends JpaRepository<Auction, Long> {

}

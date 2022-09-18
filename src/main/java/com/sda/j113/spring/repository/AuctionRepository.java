package com.sda.j113.spring.repository;

import com.sda.j113.spring.model.Auction;
import com.sda.j113.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    // findAllBy = select * from auction a where  - findAuctionBy
    // created = $1 and                           - created = $1 ... and
    // title = $2;                                - title = $2
    List<Auction> findAuctionByCreatedAndTitle(LocalDateTime created, String title);

//    @Query(value = "select count(*) from Auction a", nativeQuery = true)
//    long countAuctions();
//
//    @Query(value = "select *,(select count(*) from Auction a) from auction a order by a.id limit $1 offset ($2*$1)", nativeQuery = true)
//    long countAuctions();

//    Page<Auction> findAllBy(PageRequest pageRequest);

    List<Auction> findByProduct(Product product);
}

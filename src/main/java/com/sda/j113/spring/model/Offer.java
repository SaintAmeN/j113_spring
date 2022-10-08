package com.sda.j113.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal offerAmount;

    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime created;

    // Linked entities
    //
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Auction auction;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ApplicationUser bidder;
}

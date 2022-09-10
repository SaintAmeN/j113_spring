package com.sda.j113.spring.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Data // getter // setter // toString // equalsAndHashCode // requiredArgsConstructor
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private BigDecimal initialPrice;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @CreationTimestamp
    private LocalDateTime created;

    // TODO: formula - specjalne zapytanie SQL które zwraca
    //                  wam wartośc w momencie pobrania rekordu
    //                  (dodatkowe pole które nie jest kolumną)
    //                  Formula:
    //                     ilość ofert dodanej licytacji (count())

    // Linked entities
    //
    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Product product;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "auction")
    private Set<Offer> offers;
}

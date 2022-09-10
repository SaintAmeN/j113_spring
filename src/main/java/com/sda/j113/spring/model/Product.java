package com.sda.j113.spring.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createDateTime; // now()

    @UpdateTimestamp
    private LocalDateTime updateDateTime; // now()

    @Enumerated(EnumType.STRING)
    private ProductState state;

    // Linked entities
    //
    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ApplicationUser owner;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product")
    private Set<Auction> auctions;

}

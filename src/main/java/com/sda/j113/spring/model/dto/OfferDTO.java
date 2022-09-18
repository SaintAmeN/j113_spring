package com.sda.j113.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 18.09.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDTO {
    private Long offerId;
    private Long auctionId;
    private BigDecimal offerAmount;
    private LocalDateTime submittedAt;
}

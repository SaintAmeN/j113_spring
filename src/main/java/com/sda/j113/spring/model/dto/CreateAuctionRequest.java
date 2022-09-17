package com.sda.j113.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 *
 * MVP - Minimum Viable Product
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuctionRequest {
    private Long productId;
    private String title;
    private BigDecimal initialPrice;

    private LocalDateTime startDateTime;
    private int durationInDays;
}

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
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionDTO {
    private Long auctionId;
    private Long productId;

    private String title;
    private BigDecimal initialPrice;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}

package com.sda.j113.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 18.09.2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDTO {
    private ApplicationUserDTO owner;
    private ProductDTO product;
    private List<AuctionDTO> auctions;
    private List<OfferDTO> offers;
}

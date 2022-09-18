package com.sda.j113.spring.model.mapper;

import com.sda.j113.spring.model.Offer;
import com.sda.j113.spring.model.dto.OfferDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
@Mapper(componentModel = "spring")
public interface OfferMapper {

//    TODO: w domku, robimy listowanie ofert
//    @Mappings(value = {
//    })
//    Offer mapCreateProductRequestToProduct(Auction auction,
//                                           SubmitOfferRequest request);

    @Mappings(value = {
            @Mapping(target = "offerId", source = "id"),
            @Mapping(target = "auctionId", source = "auction.id"),
            @Mapping(target = "offerAmount", source = "offerAmount"),
            @Mapping(target = "submittedAt", source = "created")
    })
    OfferDTO mapProductToDTO(Offer offer);
}

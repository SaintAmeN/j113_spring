package com.sda.j113.spring.model.mapper;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.Auction;
import com.sda.j113.spring.model.Product;
import com.sda.j113.spring.model.dto.AuctionDTO;
import com.sda.j113.spring.model.dto.CreateAuctionRequest;
import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
@Mapper(componentModel = "spring")
public interface AuctionMapper {

    @Mappings(value = {
        @Mapping(target="id", ignore = true),
        @Mapping(target="title", source = "request.title"),
        @Mapping(target="initialPrice", source = "request.initialPrice"),
        @Mapping(target="startDateTime", source = "request.startDateTime"),
        @Mapping(target="endDateTime", expression = "java(request.getStartDateTime().plusDays(request.getDurationInDays()))"),
        @Mapping(target="product", source = "product"),
    })
    Auction mapCreateAuctionRequestToAuction(Product product,
                                             CreateAuctionRequest request);

    @Mappings(value = {
            @Mapping(target="auctionId", source = "id"),
            @Mapping(target="productId", source = "auction.product.id"),
            @Mapping(target="title", source = "title"),
            @Mapping(target="initialPrice", source = "initialPrice"),
            @Mapping(target="startDateTime", source = "startDateTime"),
            @Mapping(target="endDateTime", source = "endDateTime"),
    })
    AuctionDTO mapAuctionToDTO(Auction auction);


}

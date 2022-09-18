package com.sda.j113.spring.model.mapper;

import org.mapstruct.Mapper;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 18.09.2022
 */
@Mapper(componentModel = "spring",
        uses = {
                OfferMapper.class,
                AuctionMapper.class,
                ProductMapper.class
        })
public interface ProductDetailsMapper {
}

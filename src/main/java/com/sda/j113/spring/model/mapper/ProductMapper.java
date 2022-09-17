package com.sda.j113.spring.model.mapper;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.Product;
import com.sda.j113.spring.model.dto.ApplicationUserDTO;
import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.CreateUserRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createDateTime", ignore = true),
            @Mapping(target = "updateDateTime", ignore = true),
            @Mapping(target = "auctions", ignore = true),
            @Mapping(target = "owner", source = "user"),
            @Mapping(target = "state", source = "request.state"),
            @Mapping(target = "name", source = "request.name")
    })
    Product mapCreateProductRequestToProduct(ApplicationUser user,
                                             CreateProductRequest request);

    @Mappings(value = {
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "createDateTime", source = "createDateTime"),
            @Mapping(target = "updateDateTime", source = "updateDateTime"),
            @Mapping(target = "ownerId", source = "owner.id"),
//            @Mapping(target = "ownerId", expression = "java(product.getOwner().getId())"),
            @Mapping(target = "state", source = "state"),
            @Mapping(target = "name", source = "name")
    })
    ProductDTO mapProductToDTO(Product product);


}

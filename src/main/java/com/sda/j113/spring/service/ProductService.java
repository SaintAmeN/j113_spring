package com.sda.j113.spring.service;

import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import com.sda.j113.spring.model.dto.ProductDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
public interface ProductService {


    ProductDTO addProduct(Long userId, CreateProductRequest request);

    Page<ProductDTO> getAllProducts(PageRequest pageRequest);

    Page<ProductDTO> getUserProducts(Long userId, PageRequest pageRequest) ;

    boolean deleteProduct(Long productId);

    ProductDetailsDTO getProductDetails(Long productId);
}

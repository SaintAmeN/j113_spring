package com.sda.j113.spring.service;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.Product;
import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import com.sda.j113.spring.model.mapper.ProductMapper;
import com.sda.j113.spring.repository.ApplicationUserRepository;
import com.sda.j113.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ApplicationUserRepository applicationUserRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO addProduct(Long userId, CreateProductRequest request) {
        ApplicationUser owner = applicationUserRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new);

        Product product = productMapper.mapCreateProductRequestToProduct(owner, request);

        return productMapper.mapProductToDTO(productRepository.save(product));
    }

    @Override
    public Page<ProductDTO> getAllProducts(PageRequest pageRequest) {
        Page<Product> productsPage = productRepository.findAll(pageRequest);
        List<ProductDTO> productDTOList = productsPage.getContent().stream()
                .map(productMapper::mapProductToDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(productDTOList, productsPage.getPageable(), productsPage.getTotalElements());
    }

    @Override
    public Page<ProductDTO> getUserProducts(Long userId, PageRequest pageRequest) {
        ApplicationUser owner = applicationUserRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new);

        Page<Product> productsPage = productRepository.findAllByOwner(owner, pageRequest);
        List<ProductDTO> productDTOList = productsPage.getContent().stream()
                .map(productMapper::mapProductToDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(productDTOList, productsPage.getPageable(), productsPage.getTotalElements());
    }

    @Override
    public boolean deleteProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()){
            return false;
        }
        productRepository.deleteById(productId);
        return true;
    }
}

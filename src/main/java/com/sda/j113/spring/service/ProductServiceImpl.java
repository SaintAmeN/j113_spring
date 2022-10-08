package com.sda.j113.spring.service;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.Auction;
import com.sda.j113.spring.model.Offer;
import com.sda.j113.spring.model.Product;
import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import com.sda.j113.spring.model.dto.ProductDetailsDTO;
import com.sda.j113.spring.model.mapper.ApplicationUserMapper;
import com.sda.j113.spring.model.mapper.AuctionMapper;
import com.sda.j113.spring.model.mapper.OfferMapper;
import com.sda.j113.spring.model.mapper.ProductMapper;
import com.sda.j113.spring.repository.ApplicationUserRepository;
import com.sda.j113.spring.repository.AuctionRepository;
import com.sda.j113.spring.repository.OfferRepository;
import com.sda.j113.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    private final ApplicationUserRepository applicationUserRepository;
    private final ProductRepository productRepository;
    private final AuctionRepository auctionRepository;
    private final OfferRepository offerRepository;

    private final ApplicationUserMapper applicationUserMapper;
    private final ProductMapper productMapper;
    private final AuctionMapper auctionMapper;
    private final OfferMapper offerMapper;

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

    @Override
    public ProductDetailsDTO getProductDetails(Long productId) {
        // Product
        Product product = productRepository.findById(productId)
                .orElseThrow(EntityNotFoundException::new);

        // User
        ApplicationUser owner = product.getOwner();

        // Aukcje
        List<Auction> auctions = auctionRepository.findByProduct(product);

        // Oferty
        List<Offer> allOffersToAllAuctions = new ArrayList<>();
        for (Auction auction : auctions) {
            allOffersToAllAuctions.addAll(offerRepository.findAllByAuction(auction));
        }

        return ProductDetailsDTO.builder()
                .product(productMapper.mapProductToDTO(product))
                .owner(applicationUserMapper.mapApplicationUserToDTO(owner))
                .auctions(auctions.stream()
                        .map(auctionMapper::mapAuctionToDTO)
                        .collect(Collectors.toList()))
                .offers(allOffersToAllAuctions.stream()
                        .map(offerMapper::mapProductToDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}

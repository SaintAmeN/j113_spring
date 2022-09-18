package com.sda.j113.spring.controller;

import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import com.sda.j113.spring.model.dto.ProductDetailsDTO;
import com.sda.j113.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
@Slf4j
@CrossOrigin
@RequestMapping("/api/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/{id}")
    public ProductDTO addProduct(@PathVariable(name = "id") Long userId,
                                 @RequestBody CreateProductRequest request) {
        return productService.addProduct(userId, request);
    }

    @PostMapping()
    public ProductDTO addProductWithRequestParam(@RequestParam(defaultValue = "1") Long userId,
                                                 @RequestBody CreateProductRequest request) {
        return productService.addProduct(userId, request);
    }

    // http://localhost:8080/api/product                    (page=0, size=10)
    // http://localhost:8080/api/product?page=1             (page=1, size=10)
    // http://localhost:8080/api/product?size=30&page=0     (page=0, size=30)
    // http://localhost:8080/api/product?page=0&size=30     (page=0, size=30)
    // http://localhost:8080/api/product?size=40            (page=0, size=40)
    @GetMapping()
    public Page<ProductDTO> getAllUserProducts(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        if (userId != null) {
            return productService.getUserProducts(userId, PageRequest.of(page, size));
        } else {
            return productService.getAllProducts(PageRequest.of(page, size));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        boolean result = productService.deleteProduct(id);
        if (result) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

//    @DeleteMapping
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public Boolean deleteProductById(Long id) {
//        return productService.deleteProduct(id);
//    }

    // Co najmniej 1 user
    // Co najmniej 1 product powiązany z tym użytkownikiem
    // (optional) 1 auction powiązany z produktem (powyżej)
    // (optional) drugi user (inny niż 1) + jedna oferta usera 2 na auction (powyżej)
    @GetMapping("/{identifier}")
    public ProductDetailsDTO getDetails(@PathVariable(name = "identifier") Long id) {
        log.info("Requested details of product with id: " + id);
        return productService.getProductDetails(id);
    }
}

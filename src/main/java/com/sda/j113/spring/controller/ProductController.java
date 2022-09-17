package com.sda.j113.spring.controller;

import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import com.sda.j113.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    // http://localhost:8080/api/product                    (page=0, size=10)
    // http://localhost:8080/api/product?page=1             (page=1, size=10)
    // http://localhost:8080/api/product?size=30&page=0     (page=0, size=30)
    // http://localhost:8080/api/product?page=0&size=30     (page=0, size=30)
    // http://localhost:8080/api/product?size=40            (page=0, size=40)
    @GetMapping()
    public Page<ProductDTO> getAllProducts(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        return productService.getAllProducts(PageRequest.of(page, size));
//                        page == null ? 0 : page,
//                        size == null ? 10 : size
//                ));
    }
}

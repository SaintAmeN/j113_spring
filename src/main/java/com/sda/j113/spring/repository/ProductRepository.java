package com.sda.j113.spring.repository;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByOwner(ApplicationUser owner, PageRequest pageRequest);
}

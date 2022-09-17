package com.sda.j113.spring.model.dto;

import com.sda.j113.spring.model.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 17.09.2022
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private LocalDateTime createDateTime; // now()
    private LocalDateTime updateDateTime; // now()
    private ProductState state;

    private Long ownerId;
}

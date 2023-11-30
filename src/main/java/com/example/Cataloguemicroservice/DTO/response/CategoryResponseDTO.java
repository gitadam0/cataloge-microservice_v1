package com.example.Cataloguemicroservice.DTO.response;

import lombok.*;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryResponseDTO {
    private Long idCategory;
    private String nomCategory;
    private List<ProductResponseDTO> produits;
}

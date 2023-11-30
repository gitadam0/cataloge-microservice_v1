package com.example.Cataloguemicroservice.DTO.request;

import com.example.Cataloguemicroservice.DTO.response.ProductResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryRequestDto {
    private Long idCategory;
    private String nomCategory;
    private List<ProductResponseDTO> produits;
}

package com.example.Cataloguemicroservice.DTO.request;

import com.example.Cataloguemicroservice.Entities.Category;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductRequestDto {
    private String nomProduit;
    private String description;
    private double prixProduit;
    private Category category;
}

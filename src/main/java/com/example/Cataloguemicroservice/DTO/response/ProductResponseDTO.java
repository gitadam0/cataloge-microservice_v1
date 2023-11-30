package com.example.Cataloguemicroservice.DTO.response;

import com.example.Cataloguemicroservice.Entities.Product;
import lombok.*;

/*
 If your transformation logic is straightforward, involves simple field mapping, and doesn't require
  extensive customization, constructor-based initialization provides a concise and readable way to create
   DTOs.*/
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder

public class ProductResponseDTO {
    private String nom;
    private String description;
    private Long idProduit;
    private double prixProduit;


}

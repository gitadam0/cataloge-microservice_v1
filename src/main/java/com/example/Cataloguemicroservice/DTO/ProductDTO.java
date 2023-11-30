package com.example.Cataloguemicroservice.DTO;

import com.example.Cataloguemicroservice.Entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 If your transformation logic is straightforward, involves simple field mapping, and doesn't require
  extensive customization, constructor-based initialization provides a concise and readable way to create
   DTOs.*/
@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    /*@NotBlank(message = "Product name is required")
    private String nomProduit;*/

    private String nom;
    private String description;
    public ProductDTO(Product product) {
        this.nom = product.getNomProduit();
        this.description = product.getDescription();
    }

}

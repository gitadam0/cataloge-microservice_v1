package com.example.Cataloguemicroservice.DTO;

import com.example.Cataloguemicroservice.Entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    /*@NotBlank(message = "Product name is required")
    private String nomProduit;*/

    private String name;
    private String description;
    private double prixProduit;
    private Long cetegoryID;

    public ProductDTO(String name, String description, double prixProduit, Long cetegoryID) {
        this.name = name;
        this.description = description;
        this.prixProduit = prixProduit;
        this.cetegoryID = cetegoryID;
    }
/*
 If your transformation logic is straightforward, involves simple field mapping, and doesn't require
  extensive customization, constructor-based initialization provides a concise and readable way to create
   DTOs.*/
 /*   public ProductDTO(Product product) {
        this.name = product.getNomProduit();
        this.description = product.getDescription();
    }
*/

}


package com.example.Cataloguemicroservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private Long idCategory;
    private String nomCategory;
    // Add more fields as needed
    private List<ProductDTO> products;
}

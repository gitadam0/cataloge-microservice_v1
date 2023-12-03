package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;

public class ProductDTOTransformer {

    public static Product transformToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setNomProduit(productDTO.getName());
        product.setDescription(productDTO.getDescription());

        Category category=new Category();
        category.setIdCategory(productDTO.getCetegoryID());
        product.setCategory(category);

        // Set other fields as needed
        return product;
    }


}
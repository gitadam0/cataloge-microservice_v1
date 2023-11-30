package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.response.ProductResponseDTO;
import com.example.Cataloguemicroservice.Entities.Product;

import java.util.List;
import java.util.stream.Collectors;
/*If your transformation logic involves complex mapping, requires customization for individual fields, or
needs to perform additional processing, a dedicated transformer class provides a clear place to
encapsulate this logic.*/
public class ProductTransformer {

    public static ProductResponseDTO transformToDTO(Product product) {
        ProductResponseDTO productDTO = new ProductResponseDTO();
        productDTO.setNom(product.getNomProduit());
        productDTO.setDescription(product.getDescription());
        // Set other fields as needed
        return productDTO;
    }

    // You can also create a method for transforming a list of products to a list of DTOs
    public static List<ProductResponseDTO> transformListToDTOList(List<Product> productList) {
        return productList.stream()
                .map(ProductTransformer::transformToDTO)
                .collect(Collectors.toList());
    }
}

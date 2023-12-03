package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;

import java.util.List;
import java.util.stream.Collectors;
/*If your transformation logic involves complex mapping, requires customization for individual fields, or
needs to perform additional processing, a dedicated transformer class provides a clear place to
encapsulate this logic.*/
public class ProductTransformer {

    public static ProductDTO transformToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getNomProduit());
        productDTO.setDescription(product.getDescription());
        // Set other fields as needed
        return productDTO;
    }

    // You can also create a method for transforming a list of products to a list of DTOs
    public static List<ProductDTO> transformListToDTOList(List<Product> productList) {
        return productList.stream()
                .map(ProductTransformer::transformToDTO)
                .collect(Collectors.toList());
    }
    public static Product transformToEntity(ProductDTO productDTO) {
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

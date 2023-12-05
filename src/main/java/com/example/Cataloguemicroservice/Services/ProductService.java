package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO product) throws MyEntityNotFoundException;
    List<ProductDTO> createProducts(List<ProductDTO> products);
    ProductDTO updateProduct(Long id, ProductDTO product) throws MyEntityNotFoundException;
    void deleteProduct(Long id);
   ProductDTO getProductById(Long id) throws MyEntityNotFoundException;
    List<Product> getProducts();
    ProductDTO addEtiquette(Long id, Long idEtiquette) throws MyEntityNotFoundException;
    ProductDTO addVariety(Long id, Long idVariety) throws MyEntityNotFoundException;

    public Product findProductByNom(String productName);
}

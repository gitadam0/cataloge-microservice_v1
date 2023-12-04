package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO product) throws EntityNotFoundException;
    List<ProductDTO> createProducts(List<ProductDTO> products);
    ProductDTO updateProduct(Long id, ProductDTO product) throws EntityNotFoundException;
    void deleteProduct(Long id);
   ProductDTO getProductById(Long id) throws EntityNotFoundException;
    List<ProductDTO> getProducts();
    ProductDTO addEtiquette(Long id, Long idEtiquette) throws EntityNotFoundException;
    ProductDTO addVariety(Long id, Long idVariety) throws EntityNotFoundException;

}

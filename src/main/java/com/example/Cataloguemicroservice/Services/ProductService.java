package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO product) throws EntityNotFoundException;
    List<Product> createProducts(List<Product> products);
    Product updateProduct(Long id, Product product) throws EntityNotFoundException;
    void deleteProduct(Long id);
   Product getProductById(Long id) throws EntityNotFoundException;
    List<Product> getProducts();
    Product addEtiquette(Long id, Long idEtiquette) throws EntityNotFoundException;
    Product addVariety(Long id, Long idVariety) throws EntityNotFoundException;

}

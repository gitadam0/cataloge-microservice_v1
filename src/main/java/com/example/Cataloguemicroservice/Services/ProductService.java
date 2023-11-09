package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Exceptions.ProductNotFoundException;
import java.util.List;

public interface ProductService {
    Produit createProduct(Produit product);
    Produit updateProduct(Long id, Produit product) throws ProductNotFoundException;
    void deleteProduct(Long id);
   Produit getProductById(Long id) throws ProductNotFoundException;
    List<Produit> getProducts();

}

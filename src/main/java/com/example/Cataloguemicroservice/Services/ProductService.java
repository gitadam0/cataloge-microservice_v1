package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;

public interface ProductService {
    Produit createProduct(Produit product);
    Produit updateProduct(Long id, Produit product) throws EntityNotFoundException;
    void deleteProduct(Long id);
   Produit getProductById(Long id) throws EntityNotFoundException;
    List<Produit> getProducts();
    Produit addEtiquette(Long id,Long idEtiquette) throws EntityNotFoundException;

}

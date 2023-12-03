package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find products by category
    List<Product> findByCategory(Category category);

    // Find products by etiquette
//    List<Produit> findByEtiquette(Etiquette etiquette);

    // Find products by price less than a specified value
    List<Product> findByPrixProduitLessThan(double maxPrice);

    // Find products by name containing a certain keyword
    List<Product> findByNomProduitContains(String keyword);
}

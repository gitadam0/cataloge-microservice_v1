package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Find products by category
    List<Produit> findByCategory(Category category);

    // Find products by etiquette
    List<Produit> findByEtiquette(Etiquette etiquette);

    // Find products by price less than a specified value
    List<Produit> findByPrixProduitLessThan(double maxPrice);

    // Find products by name containing a certain keyword
    List<Produit> findByNomProduitContains(String keyword);
}

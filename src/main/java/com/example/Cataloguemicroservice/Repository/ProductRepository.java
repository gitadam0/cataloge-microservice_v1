package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find products by category
    List<Product> findByCategory(Category category);

    // Find products by etiquette
//    List<Product> findByEtiquette(Etiquette etiquette);

    // Find products by price less than a specified value
    List<Product> findByPrixProductLessThan(double maxPrice);

    // Find products by name containing a certain keyword
    List<Product> findByNomProductContains(String keyword);

    Product findProductByNom(String nomProduct);

}

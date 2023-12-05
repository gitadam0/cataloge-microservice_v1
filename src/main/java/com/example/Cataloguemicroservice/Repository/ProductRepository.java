package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface ProductRepository extends JpaRepository<Product, Long> {
 /*   // Find products by category
    List<Product> findByCategory(Category category);

    // Find products by etiquette
//    List<Product> findByEtiquette(Etiquette etiquette);

    // Find products by price less than a specified value
    List<Product> findByPrixProductLessThan(double maxPrice);

    // Find products by name containing a certain keyword
    List<Product> findByNomProductContains(String keyword);
*/
    Product findProductBynomProduct(String nomProduct);


    //List<Product> findProductByEtiquettes(Set<Etiquette> etiquettes);
}

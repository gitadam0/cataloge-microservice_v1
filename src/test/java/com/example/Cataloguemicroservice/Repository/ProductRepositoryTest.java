package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DataJpaTest
class ProductRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void findProductByNom() {
        // Given
        Product product = new Product();
        product.setNomProduct("testt");

        // Mock the behavior of productRepository.save()
        when(productRepository.save(product)).thenReturn(product);

        // When
        Product savedProduct = productRepository.save(product);

        // Then
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getNomProduct()).isEqualTo("testt");
    }
}
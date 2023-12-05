package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.ProductRepository;
import com.example.Cataloguemicroservice.Services.Category.CategoryService;
import com.example.Cataloguemicroservice.transformers.ProductTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;
    @Mock
    CategoryService categoryService;
    @Mock
    ProductTransformer productTransformer;

    @Test
    void createProduct() throws MyEntityNotFoundException {
        Category category = new Category();
        category.setIdCategory(1L);

        Product p1 = new Product();
        p1.setNomProduct("adam");
        p1.setCategory(category);

        Product savedP1 = new Product();
        p1.setIdProduct(1L);
        p1.setNomProduct("adam");
        p1.setCategory(category);

        ProductDTO p1Dto = new ProductDTO();
        p1Dto.setIdProduct(1L);
        p1Dto.setName("adam");
        p1Dto.setCategoryID(category.getIdCategory());
        //when(productRepository.findAll()).thenReturn(List.of(p1));

        when(categoryService.getCategoryByID(1L)).thenReturn(category);
        //when(productRepository.save(any())).thenReturn(p1);
        when(productRepository.save(p1)).thenReturn(p1);

        productService.createProduct(ProductTransformer.transformToDTO(p1));

        verify(productRepository, times(1)).save(p1);
    }

    @Test
    void getProducts() {
        Product p1 = new Product();

        p1.setIdProduct(1L);
        p1.setNomProduct("adam");
        Product p2 = new Product();

        p2.setIdProduct(2L);
        p2.setNomProduct("adam");
        when(productRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Product> products = productService.getProducts();
        assertEquals(products.get(0).getNomProduct(), p1.getNomProduct());
    }

    @Test
    void getProductById() throws MyEntityNotFoundException {
        Category category = new Category();
        category.setIdCategory(1L);
        Product p1 = new Product();
        p1.setIdProduct(1L);
        p1.setNomProduct("adam");
        p1.setCategory(category);
        Product p2 = new Product();
        p2.setIdProduct(2L);
        p2.setNomProduct("adam");
        p2.setCategory(category);

        List<Product> products = Arrays.asList(p1, p2);
        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(products.get(0)));

        ProductDTO product = productService.getProductById(1L);
        assertEquals(product.getIdProduct(), ProductTransformer.transformToDTO(p1).getIdProduct());
    }
}
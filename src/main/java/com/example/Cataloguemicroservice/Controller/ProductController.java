package com.example.Cataloguemicroservice.Controller;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Exceptions.ProductNotFoundException;
import com.example.Cataloguemicroservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Produit> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Produit getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public Produit createProduct(@RequestBody Produit product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Produit updateProduct(@PathVariable Long id, @RequestBody Produit product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}

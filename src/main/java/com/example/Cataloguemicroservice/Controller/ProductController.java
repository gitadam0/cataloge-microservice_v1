package com.example.Cataloguemicroservice.Controller;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.jms.MessageSender;
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
    public Produit getProductById(@PathVariable Long id) throws EntityNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public Produit createProduct(@RequestBody Produit product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Produit updateProduct(@PathVariable Long id, @RequestBody Produit product) throws EntityNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addEtiquette/{id}/{idEtiquette}")
    public Produit addEtiquette(@PathVariable Long id,@PathVariable Long idEtiquette) throws EntityNotFoundException {
        return productService.addEtiquette(id,idEtiquette);
    }

    @PostMapping("/addVariety/{id}/{idVariety}")
    public Produit addVariety(@PathVariable Long id,@PathVariable Long idVariety) throws EntityNotFoundException {
        return productService.addVariety(id,idVariety);
    }

    @Autowired
    MessageSender messageSender;


    @GetMapping("/Test")
    public String Test() throws EntityNotFoundException {
        messageSender.sendMessage("mon message de adam");
        messageSender.sendProduct(productService.getProductById(1L));

        return "OK";
    }

    @PostMapping("/sendProduct")
    public String sendProduct(@RequestBody Produit produit) throws EntityNotFoundException {

        messageSender.sendProduct(produit);

        return "OK";
    }


}

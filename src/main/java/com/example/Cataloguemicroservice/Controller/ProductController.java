package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Services.MessagingService.YourMessagingService;
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
    @Autowired
    private YourMessagingService messagingService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) throws EntityNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) throws EntityNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addEtiquette/{id}/{idEtiquette}")
    public Product addEtiquette(@PathVariable Long id, @PathVariable Long idEtiquette) throws EntityNotFoundException {
        return productService.addEtiquette(id, idEtiquette);
    }

    @PostMapping("/addVariety/{id}/{idVariety}")
    public Product addVariety(@PathVariable Long id, @PathVariable Long idVariety) throws EntityNotFoundException {
        return productService.addVariety(id, idVariety);
    }

    @Autowired
    MessageSender messageSender;


 /*   @GetMapping("/Test")
    public String Test() throws EntityNotFoundException {
        messageSender.sendProduct(new ProductDTO(productService.getProductById(1L)) );

        return "OK";
    }
*/
    @PostMapping("/createProductInStock")
    public Product createProductInStock(@RequestBody Product product) throws EntityNotFoundException {
        messageSender.sendProduct(new ProductDTO(product));
        return productService.createProduct(product);

    }

}
